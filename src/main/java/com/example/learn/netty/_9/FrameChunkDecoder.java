package com.example.learn.netty._9;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import io.netty.handler.codec.TooLongFrameException;

import java.util.List;

public class FrameChunkDecoder extends ByteToMessageDecoder{


    private final int maxFrameSize;

    public FrameChunkDecoder(int maxFrameSize) {
        this.maxFrameSize = maxFrameSize;
    }


    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {

        int i = in.readableBytes();
        if (i > maxFrameSize) {
            in.clear();
            throw new TooLongFrameException();
        }

        ByteBuf byteBuf = in.readBytes(i);
        out.add(byteBuf);
    }
}
