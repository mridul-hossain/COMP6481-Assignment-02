public class ParticipantList {
    private ParticipantList head;
    private int size;
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

    public void setSize(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }
}
