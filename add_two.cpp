class Solution {
    public:
        ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
            ListNode* node=new ListNode(0),*ans=node;
            int carry=0;
            while (l1||l2||carry) {
                int val=carry;
                if (l1) val+=l1->val;
                if (l2) val+=l2->val;
                node->next=new ListNode(val%10);
                node=node->next;
                if (val>9) carry=1;
                else carry=0;
                if (l1) l1=l1->next;
                if (l2) l2=l2->next;
            }
            return ans->next;
        }
    };