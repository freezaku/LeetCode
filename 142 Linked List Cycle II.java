{\rtf1\ansi\ansicpg936\cocoartf1404\cocoasubrtf470
{\fonttbl\f0\fswiss\fcharset0 Helvetica;\f1\fnil\fcharset134 PingFangSC-Regular;}
{\colortbl;\red255\green255\blue255;}
\margl1440\margr1440\vieww10800\viewh8400\viewkind0
\pard\tx720\tx1440\tx2160\tx2880\tx3600\tx4320\tx5040\tx5760\tx6480\tx7200\tx7920\tx8640\pardirnatural\partightenfactor0

\f0\fs24 \cf0 /**\
 * Definition for singly-linked list.\
 * class ListNode \{\
 *     int val;\
 *     ListNode next;\
 *     ListNode(int x) \{\
 *         val = x;\
 *         next = null;\
 *     \}\
 * \}\
 */\
public class Solution \{\
    public ListNode detectCycle(ListNode head) \{\
        ListNode slow = head;\
        ListNode fast = head;\
        while(fast != null && fast.next != null) \{\
            fast = fast.next.next;\
            slow = slow.next;\
            if(fast == slow) \{\
                ListNode res = head;\
                while(res != slow) \{\
                    res = res.next;\
                    slow = slow.next;\
                \}\
                return res;\
            \}\
        \}\
        return null;\
    \}\
\}\
\
/*\

\f1 \'d4\'da
\f0 Linked List Cycle
\f1 \'bb\'f9\'b4\'a1\'c9\'cf\'bd\'e2\'be\'f6\'a3\'ac\'b4\'cb\'cc\'e2\'c9\'e8\'bc\'c6\'b5\'bd\'ca\'fd\'d1\'a7\'bc\'c6\'cb\'e3\'a3\'ac\'d0\'e8\'d2\'aa\'b8\'e3\'c7\'e5\'b3\'fe\'b9\'d8\'cf\'b5\'a3\'ac\'bc\'fb\'cf\'c2\'c3\'e6\'b7\'d6\'ce\'f6\'a3\'ba
\f0 \
\
C
\f1 \'a3\'ba\'b4\'d3
\f0 head
\f1 \'b5\'bd
\f0 cycle
\f1 \'b5\'c4\'c6\'f0\'b5\'e3\'be\'e0\'c0\'eb
\f0 \
S
\f1 \'a3\'ba\'b4\'d3
\f0 cycle
\f1 \'c6\'f0\'b5\'e3\'b5\'bd
\f0 fast
\f1 \'ba\'cd
\f0 slow
\f1 \'b5\'c4\'cf\'e0\'d3\'f6\'b5\'e3\'be\'e0\'c0\'eb
\f0 \
\
Distance(slow) = C + S, Distance(fast) = 2 * Distance(slow) = 2 * (C + S). \
To let slow poiner meets fast pointer, only if fast pointer run 1 cycle more than slow pointer. Distance(fast) - Distance(slow) = Cycle\
\
=> 2 * (C + S) - (C + S)	= Cycle\
=>	C + S = Cycle\
=>	C = Cycle - S\

\f1 \'bc\'b4\'b4\'d3
\f0 head
\f1 \'b5\'bd
\f0 cycle
\f1 \'c6\'f0\'b5\'e3\'b5\'c4\'be\'e0\'c0\'eb\'a3\'ac\'be\'cd\'ca\'c7\'b4\'d3\'cf\'e0\'d3\'f6\'b5\'e3\'d4\'d9\'b4\'ce\'b5\'bd\'b4\'ef
\f0 cycle
\f1 \'c6\'f0\'b5\'e3\'b5\'c4\'be\'e0\'c0\'eb
\f0 \

\f1 \'d4\'d9\'c9\'e8\'c1\'a2\'d2\'bb\'b8\'f6
\f0 pointer
\f1 \'b4\'d3\'c6\'f0\'b5\'e3\'b3\'f6\'b7\'a2\'a3\'ac
\f0 slow
\f1 \'d5\'d5\'b3\'a3\'d4\'cb\'d0\'d0\'a3\'ac\'cf\'c2\'b4\'ce\'cb\'fb\'c3\'c7\'b5\'c4\'cf\'e0\'d3\'f6\'b5\'e3\'bc\'b4\'ce\'aa
\f0 cycle
\f1 \'b5\'c4\'c6\'f0\'b5\'e3\'a1\'a3
\f0 \
*/}