package cloud_game;

public interface CloudInter {

    public void setNewHighForLevel(int level);

    public int getPositionX();

    public void setPositionX(int positionX);

    public int getPositionY();

    public void setPositionY(int positionY);

    public void decreasePosY();

    public void increasePosY();

    public int getCloudType();

    void setTypeOfCloud(int level);
}
