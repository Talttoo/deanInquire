package com.julong.deanInquire.utils.other;
import java.util.Vector;
public class Base64CodecUtil {
    public static Vector Base64Tokens = new Vector(64);
        static
        {
            Base64Tokens.add("A");
            Base64Tokens.add("B");
            Base64Tokens.add("C");
            Base64Tokens.add("D");
            Base64Tokens.add("E");
            Base64Tokens.add("F");
            Base64Tokens.add("G");
            Base64Tokens.add("H");
            Base64Tokens.add("I");
            Base64Tokens.add("J");
            Base64Tokens.add("K");
            Base64Tokens.add("L");
            Base64Tokens.add("M");
            Base64Tokens.add("N");
            Base64Tokens.add("O");
            Base64Tokens.add("P");
            Base64Tokens.add("Q");
            Base64Tokens.add("R");
            Base64Tokens.add("S");
            Base64Tokens.add("T");
            Base64Tokens.add("U");
            Base64Tokens.add("V");
            Base64Tokens.add("W");
            Base64Tokens.add("X");
            Base64Tokens.add("Y");
            Base64Tokens.add("Z");
            Base64Tokens.add("a");
            Base64Tokens.add("b");
            Base64Tokens.add("c");
            Base64Tokens.add("d");
            Base64Tokens.add("e");
            Base64Tokens.add("f");
            Base64Tokens.add("g");
            Base64Tokens.add("h");
            Base64Tokens.add("i");
            Base64Tokens.add("j");
            Base64Tokens.add("k");
            Base64Tokens.add("l");
            Base64Tokens.add("m");
            Base64Tokens.add("n");
            Base64Tokens.add("o");
            Base64Tokens.add("p");
            Base64Tokens.add("q");
            Base64Tokens.add("r");
            Base64Tokens.add("s");
            Base64Tokens.add("t");
            Base64Tokens.add("u");
            Base64Tokens.add("v");
            Base64Tokens.add("w");
            Base64Tokens.add("x");
            Base64Tokens.add("y");
            Base64Tokens.add("z");
            Base64Tokens.add("0");
            Base64Tokens.add("1");
            Base64Tokens.add("2");
            Base64Tokens.add("3");
            Base64Tokens.add("4");
            Base64Tokens.add("5");
            Base64Tokens.add("6");
            Base64Tokens.add("7");
            Base64Tokens.add("8");
            Base64Tokens.add("9");
            Base64Tokens.add("+");
            Base64Tokens.add("/");
        }
        public static final char Base64Pad = '=';
        public static final char Linefeed = (char)10;
        public static final char Carriage = (char)13;
        public static final int  LineMax = 75;

        public Base64CodecUtil()
        {
        }

        public static String encode(String source)
        {
            byte[] sourceBytes = source.getBytes();
            int byteTriad = sourceBytes.length % 3;
            StringBuffer encoding = new StringBuffer();
            int bitOffset = 7;
            int b64Offset = 5;
            int bytePlace = 0;
            byte tokenValue = (byte)0;
            int lineLength = 0;
            while(bytePlace < sourceBytes.length)
            {
                tokenValue = (byte)((byte)tokenValue | (byte)((sourceBytes[bytePlace] & (1 << bitOffset)) > 0 ? (1 << b64Offset) : (byte)0));
                bitOffset--;
                if(bitOffset < 0)
                {
                    bitOffset = 7;
                    bytePlace++;
                }
                b64Offset--;
                if(b64Offset < 0)
                {
                    b64Offset = 5;
                    encoding.append((String)(Base64Tokens.elementAt(tokenValue)));
                    tokenValue = (byte)0;
                    lineLength++;
                    if(lineLength > LineMax)
                    {
                        encoding.append(Carriage);
                        encoding.append(Linefeed);
                        lineLength = 0;
                    }
                }
            }
            if(b64Offset != 5)
            {
                bytePlace--;
                for(int i = b64Offset; i >= 0; i--)
                {
                    if(bitOffset >= 0)
                    {
                        tokenValue = (byte)((byte)tokenValue | (byte)((sourceBytes[bytePlace] & (1 << bitOffset)) > 0 ? (1 << i) : (byte)0));
                    }
                    bitOffset--;
                }
                encoding.append((String)(Base64Tokens.elementAt(tokenValue)));
            }
            if(byteTriad == 2)
            {
                encoding.append(Base64Pad);
            }
            else if(byteTriad == 1)
            {
                encoding.append(Base64Pad);
                encoding.append(Base64Pad);
            }
            return encoding.toString();
        }

        public static String decode(String source)
        {
            StringBuffer decoding = new StringBuffer();
            int bitOffset = 7;
            int b64Offset = 5;
            int bytePlace = 0;
            byte charValue = (byte)0;
            while(bytePlace < source.length())
            {
                if(source.charAt(bytePlace) == Base64Pad)
                {
                    // end processing when encountering special end-padding character
                    break;
                }
                if(source.charAt(bytePlace) == Linefeed || source.charAt(bytePlace) == Carriage)
                {
                    // ignore standard line break characters
                    bytePlace++;
                    continue;
                }
                else
                {
                    if(!Base64Tokens.contains(source.substring(bytePlace, bytePlace + 1)))
                    {
                        // ignore unknown characters (mostly implemented to deal with other line break character sequences)
                        bytePlace++;
                        continue;
                    }
                    else
                    {
                        byte currentByte = (byte)(Base64Tokens.indexOf(source.substring(bytePlace, bytePlace + 1)));
                        charValue = (byte)((byte)charValue | (byte)((currentByte & (1 << b64Offset)) > 0 ? (1 << bitOffset) : (byte)0));
                        bitOffset--;
                        if(bitOffset < 0)
                        {
                            bitOffset = 7;
                            decoding.append((char)charValue);
                            charValue = (byte)0;
                        }
                        b64Offset--;
                        if(b64Offset < 0)
                        {
                            b64Offset = 5;
                            bytePlace++;
                        }
                    }
                }
            }
            byte[] sourceBytes = new byte[decoding.length()];
            for(int i = 0; i < decoding.length(); i++){
                sourceBytes[i] = (byte)decoding.charAt(i);
            }
            return new String(sourceBytes);
            //return decoding.toString();
        }
    }
