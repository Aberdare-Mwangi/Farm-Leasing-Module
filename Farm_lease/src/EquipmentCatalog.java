import java.util.ArrayList;

public class EquipmentCatalog {
    private ArrayList<Equipment>equipmentList;
    public EquipmentCatalog(){
        equipmentList= new ArrayList<>();
        initializeEquipment();
    }
    private void
    initializeEquipment(){
        equipmentList.add(new Equipment("Harvester"," John Deere heavy","It is used for wheat,barley harvesting,packing,threashing",300,3000));
        equipmentList.add(new Equipment("Tractor"," Massey Ferguson","It is used for ploughing,harrowing,planting",400,3000));
        equipmentList.add(new Equipment("Modern pump"," Spraying pump"," Automatic carriage pump for pestside,herbicide application.",300,800));

    }
    public ArrayList<Equipment>
    getEquipmentList() {
        return equipmentList;
    }

}
