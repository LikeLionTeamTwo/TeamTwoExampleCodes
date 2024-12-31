package org.example.itemEnhancement;

public class ItemDTO {
    private int weoponLevel;
    private int armorLevel;

    public ItemDTO(){

    }
    public ItemDTO(int weoponLevel, int armorLevel) {
        this.weoponLevel = weoponLevel;
        this.armorLevel = armorLevel;
    }

    public int getWeoponLevel() {
        return weoponLevel;
    }

    public void setWeoponLevel(int weoponLevel) {
        this.weoponLevel = weoponLevel;
    }

    public int getArmorLevel() {
        return armorLevel;
    }

    public void setArmorLevel(int armorLevel) {
        this.armorLevel = armorLevel;
    }

    @Override
    public String toString() {
        return "ItemDTO{" +
                "weoponLevel=" + weoponLevel +
                ", armorLevel=" + armorLevel +
                '}';
    }
}
