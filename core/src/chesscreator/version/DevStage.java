package chesscreator.version;


public enum DevStage {
    PRE_ALPHA, ALPHA, BETA, RELEASE;

    @Override
    public String toString(){
        return super.toString().toLowerCase();
    }

    public boolean shouldDisplayDevStage(){
        return this != RELEASE;
    }
}
