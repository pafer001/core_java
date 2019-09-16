package com.example.learn.netty._9;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;

public class FixedLengthFrameDecoder  extends ByteToMessageDecoder{

    private final int frameLength;

    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        while (in.readableBytes() >= frameLength) {
            ByteBuf byteBuf = in.readBytes(frameLength);
            out.add(byteBuf);
        }
    }


    public FixedLengthFrameDecoder(int frameLength) {

        if (frameLength < 0) {
            throw new IllegalArgumentException("frameLength must be a positive integer : " + frameLength);
        }
        this.frameLength = frameLength;
    }



}