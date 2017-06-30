{\rtf1\ansi\ansicpg936\cocoartf1404\cocoasubrtf470
{\fonttbl\f0\fswiss\fcharset0 Helvetica;\f1\fnil\fcharset134 PingFangSC-Regular;}
{\colortbl;\red255\green255\blue255;}
\margl1440\margr1440\vieww10800\viewh8400\viewkind0
\pard\tx720\tx1440\tx2160\tx2880\tx3600\tx4320\tx5040\tx5760\tx6480\tx7200\tx7920\tx8640\pardirnatural\partightenfactor0

\f0\fs24 \cf0 public class Solution \{\
    public int maxProfit(int[] prices) \{\
        if(prices == null || prices.length == 0)    return 0;\
        int[] leftMax = new int[prices.length];\
        leftMax[0] = 0;\
        int leftMin = prices[0];\
        for(int i = 1; i < prices.length; i ++) \{\
            if(prices[i] < leftMin) \{\
                leftMin = prices[i];\
            \} \
            leftMax[i] = Math.max(leftMax[i - 1], prices[i] - leftMin);\
        \}\
        int[] rightMax = new int[prices.length];\
        rightMax[prices.length - 1] = 0;\
        int right = prices[prices.length - 1];\
        for(int i = prices.length - 2; i >= 0; i --) \{\
            if(prices[i] > right) \{\
                right = prices[i];\
            \} \
            rightMax[i] = Math.max(rightMax[i + 1], right - prices[i]);\
        \}\
        int res = 0;\
        for(int i = 0; i < prices.length - 1; i ++) \{\
            res = Math.max(res, leftMax[i] + rightMax[i + 1]);\
        \}\
        return Math.max(res, leftMax[prices.length - 1]);\
    \}\
\}\
\
/*\

\f1 \'b4\'d3\'d7\'f3\'b5\'bd\'d3\'d2\'c0\'fb\'d3\'c3
\f0 leftProfit
\f1 \'ca\'fd\'d7\'e9\'b4\'e6\'b4\'a2\'b5\'bd\'b8\'c3\'ce\'bb\'d6\'c3\'b5\'c4\'d7\'ee\'b4\'f3
\f0 profit
\f1 \'a3\'ba
\f0 \
1. 
\f1 \'b6\'d4\'c3\'bf\'b8\'f6
\f0 prices[i]
\f1 \'a3\'ac\'c5\'d0\'b6\'cf\'ca\'c7\'b7\'f1\'d0\'a1\'d3\'da\'d7\'ee\'d0\'a1\'d6\'b5\'a3\'ac\'c8\'f4\'d0\'a1\'d3\'da\'a3\'ac\'d4\'f2\'b8\'fc\'d0\'c2\'d7\'ee\'d0\'a1\'d6\'b5\'a3\'bb
\f0 \
2. 
\f1 \'b6\'d4\'c3\'bf\'b8\'f6
\f0 prices[i]
\f1 \'a3\'ac\'c5\'d0\'b6\'cf\'c6\'e4\'bc\'f5\'c8\'a5\'d7\'ee\'d0\'a1\'d6\'b5\'c4\'dc\'b7\'f1\'b5\'c3\'b5\'bd\'b1\'c8\'d7\'ee\'b4\'f3\'d6\'b5\'b8\'fc\'b4\'f3\'b5\'c4\'d6\'b5\'a3\'ac\'c8\'f4\'b4\'f3\'d3\'da\'a3\'ac\'d4\'f2\'b8\'fc\'d0\'c2\'d7\'ee\'b4\'f3\'d6\'b5\'a3\'bb
\f0 \
3. 
\f1 \'bd\'ab\'d7\'ee\'b4\'f3\'d6\'b5\'b4\'e6\'c8\'eb
\f0 leftProfit[i]
\f1 \'d7\'f7\'ce\'aa\'b5\'b1\'c7\'b0\'ce\'bb\'d6\'c3\'c4\'dc\'b9\'bb\'b5\'c3\'b5\'bd\'b5\'c4\'d7\'ee\'b4\'f3
\f0 profit\
\

\f1 \'b4\'d3\'d3\'d2\'b5\'bd\'d7\'f3\'c0\'fb\'d3\'c3
\f0 rightProfit
\f1 \'ca\'fd\'d7\'e9\'b4\'e6\'b4\'a2\'b4\'d3\'b8\'c3\'ce\'bb\'d6\'c3\'bf\'aa\'ca\'bc\'b5\'bd\'d7\'ee\'ba\'f3\'b5\'c4\'d7\'ee\'b4\'f3
\f0 profit\
1. 
\f1 \'b6\'d4\'c3\'bf\'b8\'f6
\f0 prices[i]
\f1 \'a3\'ac\'c5\'d0\'b6\'cf\'ca\'c7\'b7\'f1\'b4\'f3\'d3\'da\'d7\'ee\'b4\'f3\'d6\'b5\'a3\'ac\'c8\'f4\'b4\'f3\'d3\'da\'a3\'ac\'d4\'f2\'b8\'fc\'d0\'c2\'d7\'ee\'b4\'f3\'d6\'b5\'a3\'bb
\f0 \
2. 
\f1 \'b6\'d4\'c3\'bf\'b8\'f6
\f0 prices[i]
\f1 \'a3\'ac\'c5\'d0\'b6\'cf\'d7\'ee\'b4\'f3\'d6\'b5\'bc\'f5\'c8\'a5\'cb\'fb\'c4\'dc\'b7\'f1\'b5\'c3\'b5\'bd\'b1\'c8\'d7\'ee\'b4\'f3\'d6\'b5\'b8\'fc\'b4\'f3\'b5\'c4\'d6\'b5\'a3\'ac\'c8\'f4\'b4\'f3\'d3\'da\'a3\'ac\'d4\'f2\'b8\'fc\'d0\'c2\'d7\'ee\'b4\'f3\'d6\'b5\'a3\'bb
\f0 \
3. 
\f1 \'bd\'ab\'d7\'ee\'b4\'f3\'d6\'b5\'b4\'e6\'c8\'eb
\f0 rightProfit[i]
\f1 \'d7\'f7\'ce\'aa\'b5\'b1\'c7\'b0\'ce\'bb\'d6\'c3\'c4\'dc\'b9\'bb\'b5\'c3\'b5\'bd\'b5\'c4\'d7\'ee\'b4\'f3
\f0 profit\
\

\f1 \'b4\'d3\'cd\'b7\'b5\'bd\'ce\'b2\'b1\'e9\'c0\'fa\'a3\'ac\'d7\'ee\'b4\'f3
\f0 profit
\f1 \'ce\'aa
\f0 leftProfit[i] + rightProfit[i + 1]
\f1 \'b5\'c4\'d6\'b5\'a3\'ac\'b5\'ab\'d5\'e2\'d6\'bb\'ca\'c7\'c1\'bd\'b4\'ce\'bd\'bb\'d2\'d7\'b5\'c3\'b5\'bd\'b5\'c4\'d7\'ee\'b4\'f3\'d6\'b5\'a1\'a3
\f0 \
\

\f1 \'bb\'b9\'d0\'e8\'d2\'aa\'bd\'ab\'c6\'e4\'d3\'eb\'d2\'bb\'b4\'ce\'bd\'bb\'d2\'d7\'b5\'c3\'b5\'bd\'b5\'c4\'d7\'ee\'b4\'f3\'d6\'b5\'bd\'f8\'d0\'d0\'b1\'c8\'bd\'cf\'a3\'ac\'bc\'b4\'d3\'eb
\f0 leftProfit[n - 1]
\f1 \'b1\'c8\'bd\'cf\'a3\'ac\'b5\'c3\'b5\'bd\'d7\'ee\'d6\'d5\'b5\'c4\'d7\'ee\'b4\'f3\'d6\'b5\'a1\'a3
\f0 \
*/}