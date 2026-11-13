class MinStack {
private:
    class Node{
        public:
            int val;
            int min;
            Node* next;
            Node(int val,int min,Node* next){
                this->val=val;
                this->min=min;
                this->next=next;
            }
    };
    Node* head;
public:
    MinStack() {
        head=nullptr;
    }
    
    void push(int val) {
        if(head==nullptr){
            head=new Node(val,val,nullptr);
        }else{
            head=new Node(val,min(head->min,val),head);
        }
    }
    
    void pop() {
        if(head==nullptr) return;
        else{
            Node* temp=head;
            head=head->next;
            delete temp;
        }
    }
    
    int top() {
        return head->val;
    }
    
    int getMin() {
        return head->min;
    }
};
