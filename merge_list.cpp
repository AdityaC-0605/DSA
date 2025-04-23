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
    ListNode* mergeTwoLists(ListNode* list1, ListNode* list2) {
        // Base cases
        if (!list1) return list2;
        if (!list2) return list1;

        // Initialize pointers
        ListNode* head = nullptr;
        ListNode* tail = nullptr;

        // Choose the smaller head to start
        if (list1->val < list2->val) {
            head = tail = list1;
            list1 = list1->next;
        } else {
            head = tail = list2;
            list2 = list2->next;
        }

        // Merge the lists
        while (list1 && list2) {
            if (list1->val < list2->val) {
                tail->next = list1;
                list1 = list1->next;
            } else {
                tail->next = list2;
                list2 = list2->next;
            }
            tail = tail->next;
        }

        // Attach the remaining nodes
        tail->next = list1 ? list1 : list2;

        return head;
    }
};