package chesscreator.version;

public class Version {
    private DevStage devStage;

    private String versionString;
    private String snapshotString;

    public Version(DevStage devStage, String versionString){
        init(devStage, versionString);
    }

    public Version(DevStage devStage, String versionString, String snapshotString){
        init(devStage, versionString);
        this.snapshotString = snapshotString;
    }

    private void init(DevStage devStage, String versionString){
        this.devStage = devStage;

        this.versionString = versionString;
    }

    public String toString(){
        String baseVersionString = "v."+versionString+"-";

        String gameStageVersion = (devStage.shouldDisplayDevStage() ? devStage.toString() : "");
        String snapshotVersionString = (isStableRelease() ? "-SNAPSHOT-" + snapshotString : "");

        return baseVersionString + gameStageVersion + snapshotVersionString;
    }


    public boolean isStableRelease(){
        return snapshotString != null;
    }
}
