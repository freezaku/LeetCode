{\rtf1\ansi\ansicpg936\cocoartf1404\cocoasubrtf470
{\fonttbl\f0\fswiss\fcharset0 Helvetica;\f1\fnil\fcharset134 PingFangSC-Regular;}
{\colortbl;\red255\green255\blue255;}
\margl1440\margr1440\vieww10800\viewh8400\viewkind0
\pard\tx720\tx1440\tx2160\tx2880\tx3600\tx4320\tx5040\tx5760\tx6480\tx7200\tx7920\tx8640\pardirnatural\partightenfactor0

\f0\fs24 \cf0 public class Solution \{\
    public int singleNumber(int[] nums) \{\
        int a = 0;\
        int b = 0;\
        for(int num: nums) \{\
            int temp = (~a & b & num) | (a & ~b & ~num);\
            b = (~a & ~b & num) | (~a & b & ~num);\
            a = temp;\
        \}\
        return a | b;\
    \}\
\}\
\
/*\

\f1 \'c0\'fb\'d3\'c3\'c8\'fd\'bd\'f8\'d6\'c6\'c0\'b4\'bd\'f8\'d0\'d0\'bc\'c6\'cb\'e3\'a3\'ac\'d0\'e8\'d2\'aa\'ce\'ca\'d2\'bb\'cf\'c2\'b1\'f0\'c8\'cb\'d5\'e2\'b8\'f6\'ca\'c7\'d4\'f5\'c3\'b4\'c0\'fb\'d3\'c3\'b5\'e7\'c2\'b7\'c9\'e8\'bc\'c6\'b5\'c4\'d6\'aa\'ca\'b6\'b5\'c3\'b5\'bd\'b5\'c4\'bd\'e1\'c2\'db
\f0 \
*/\
\
public class Solution \{\
    public int singleNumber(int[] nums) \{\
        int res = 0;\
        for(int i = 0; i < 32; i ++) \{\
            int sum = 0;\
            for(int j = 0; j < nums.length; j ++) \{\
                if(((nums[j] >> i) & 1) == 1) \{\
                    sum ++;\
                \}\
            \}\
            sum %= 3;\
            res |= sum << i;\
        \}\
        return res;\
    \}\
\}\
/*\

\f1 \'c0\'fb\'d3\'c3\'c3\'bf\'d2\'bb\'ce\'bb\'c0\'b4\'bd\'f8\'d0\'d0\'bc\'c6\'cb\'e3\'a3\'ac
\f0 \

\f1 \'d3\'c3sum\'bd\'f8\'d0\'d0\'c3\'bf\'d2\'bb\'ce\'bb\'b5\'c4\'bc\'c6\'ca\'fd\'a3\'ac\
\'b7\'d6\'b1\'f0\'bd\'ab\'c3\'bf\'b8\'f6\'ca\'fd\'b5\'c4\'b9\'cc\'b6\'a8\'ce\'bb\'c8\'a1\'b3\'f6\'a3\'ac\'b8\'fa1\'bd\'f8\'d0\'d0\'ce\'bb\'d3\'eb\'a3\'ac\
\'c8\'f4\'ce\'aa1\'d4\'f2\'b1\'ed\'c3\'f7\'b8\'c3\'ce\'bb\'ce\'aa1\'a3\'ac\
\'cd\'ac\'ca\'b1\'c3\'bf\'b4\'ce\'b6\'bc%3\'a3\'ac\'b1\'a3\'d6\'a4\'b3\'f6\'cf\'d6\'c8\'fd\'b4\'ce1\'b5\'c4\'ca\'b1\'ba\'f2\'a3\'ac\'bd\'ab\'c6\'e4\'d6\'c3\'ce\'aa0\'a3\'ac\
\'d7\'ee\'ba\'f3sum\'d5\'e2\'d2\'bb\'ce\'bb\'bc\'b4\'ce\'aa\'c4\'c7\'b8\'f6\'b3\'f6\'cf\'d6\'b4\'ce\'ca\'fd\'b2\'bb\'ce\'aa3\'b5\'c4\'c4\'c7\'b8\'f6\'ca\'fd\'b8\'c3\'ce\'bb\'c9\'cf\'b5\'c4\'ca\'fd\'a3\'ac\
\'b0\'d1\'cb\'fb\'c3\'c7\'bb\'f2\'b5\'bd\'d7\'ee\'d6\'d5\'b5\'c4res\'c9\'cf\'bc\'b4\'bf\'c9
\f0 \
*/}