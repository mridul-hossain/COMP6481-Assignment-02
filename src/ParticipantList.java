public class ParticipantList {
    private ParticipantNode head;
    private int size;

    public ParticipantList(){
        this.head = null;
        this.size = 0;
    }

    public class ParticipantNode{
        private Participant p;
        private ParticipantNode node;

        public ParticipantNode(){
            this.p = null;
            this.node = null;
        }

        public ParticipantNode(Participant p, ParticipantNode node){
            this.p = p;
            this.node = node;
        }

        public void setP(Participant p) {
            this.p = p;
        }

        public Participant getP() {
            return p;
        }

        public void setNode(ParticipantNode node) {
            this.node = node;
        }

        public ParticipantNode getNode() {
            return node;
        }
    }

    public void setHead(ParticipantNode head){
        this.head = head;
    }

    public ParticipantNode getHead() {
        return head;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    public void addToStart(Participant p){
        head = new ParticipantNode(p, head);
        size++;
    }
}
