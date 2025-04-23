#include <iostream>
using namespace std;

// Define ListNode structure
struct ListNode {
    int val;
    ListNode *next;
    ListNode() : val(0), next(nullptr) {}
    ListNode(int x) : val(x), next(nullptr) {}
    ListNode(int x, ListNode *next) : val(x), next(next) {}
};

class Solution {
public:
    ListNode* swapPairs(ListNode* head) {
        if (!head || !head->next) {
            return head;  // Edge case: empty list or single node
        }

        ListNode *prev = nullptr;
        ListNode *cur = head;
        ListNode *next = head->next;
        head = next;  // New head after swapping

        while (cur && next) {
            // Swap nodes
            cur->next = next->next;
            next->next = cur;
            if (prev) {
                prev->next = next;
            }

            // Move pointers forward
            prev = cur;
            cur = cur->next;
            next = (cur != nullptr) ? cur->next : nullptr;
        }

        return head;
    }
};