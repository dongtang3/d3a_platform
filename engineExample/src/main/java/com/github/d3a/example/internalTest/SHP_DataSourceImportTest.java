package com.github.d3a.example.internalTest;

import com.github.d3a.engine.core.exception.EngineServiceRuntimeException;
import com.github.d3a.example.tools.SHP_DataSourceImport;
import org.opengis.referencing.FactoryException;

import java.io.File;
import java.io.IOException;

public class SHP_DataSourceImportTest {

    public static void main(String[] args) throws EngineServiceRuntimeException, FactoryException, IOException {
        //String shpFileLocation = "/home/wangychu/Desktop/GYD_GYW_GIS_DATA/GYD-GIS_WGS84/gyd-building.shp";
        //String conceptionKindName = "GYD_Building";
        //String shpFileLocation = "/home/wangychu/Desktop/GYD_GYW_GIS_DATA/GYD-GIS_WGS84/gyd-busStop.shp";
        //String conceptionKindName = "GYD_BusStop";
        //String shpFileLocation = "/home/wangychu/Desktop/GYD_GYW_GIS_DATA/GYD-GIS_WGS84/gyd-frutex.shp";
        //String conceptionKindName = "GYD_Frutex";
        //String shpFileLocation = "/home/wangychu/Desktop/GYD_GYW_GIS_DATA/GYD-GIS_WGS84/gyd-functionalZone.shp";
        //String conceptionKindName = "GYD_FunctionalZone";
        //String shpFileLocation = "/home/wangychu/Desktop/GYD_GYW_GIS_DATA/GYD-GIS_WGS84/gyd-individualTree.shp";
        //String conceptionKindName = "GYD_IndividualTree";
        //String shpFileLocation = "/home/wangychu/Desktop/GYD_GYW_GIS_DATA/GYD-GIS_WGS84/gyd-physicequipment.shp";
        //String conceptionKindName = "GYD_PhysicEquipment";
        //String shpFileLocation = "/home/wangychu/Desktop/GYD_GYW_GIS_DATA/GYD-GIS_WGS84/gyd-POI.shp";
        //String conceptionKindName = "GYD_LandMark";
        //String shpFileLocation = "/home/wangychu/Desktop/GYD_GYW_GIS_DATA/GYD-GIS_WGS84/gyd-regionName.shp";
        //String conceptionKindName = "GYD_RegionName";
        //String shpFileLocation = "/home/wangychu/Desktop/GYD_GYW_GIS_DATA/GYD-GIS_WGS84/gyd-road.shp";
        //String conceptionKindName = "GYD_Road";
        //String shpFileLocation = "/home/wangychu/Desktop/GYD_GYW_GIS_DATA/GYD-GIS_WGS84/gyd-scope.shp";
        //String conceptionKindName = "GYD_Scope";
        //String shpFileLocation = "/home/wangychu/Desktop/GYD_GYW_GIS_DATA/GYD-GIS_WGS84/gyd-sectionBlock.shp";
        //String conceptionKindName = "GYD_SectionBlock";
        //String shpFileLocation = "/home/wangychu/Desktop/GYD_GYW_GIS_DATA/GYD-GIS_WGS84/gyd-viewpoint.shp";
        //String conceptionKindName = "GYD_Viewpoint";
        //String shpFileLocation = "/home/wangychu/Desktop/GYD_GYW_GIS_DATA/GYD-GIS_WGS84/gyd-water.shp";
        //String conceptionKindName = "GYD_Water";
        //String shpFileLocation = "/home/wangychu/Desktop/GYD_GYW_GIS_DATA/GYD-GIS_WGS84/gyd-zoneSection.shp";
        //String conceptionKindName = "GYD_ZoneSection";
        //String shpFileLocation = "/home/wangychu/Desktop/GYD_GYW_GIS_DATA/GYW-GIS_WGS84/公交站场规划PL.shp";
        //String conceptionKindName = "GYW_BusStationField_Plan";
        //String shpFileLocation = "/home/wangychu/Desktop/GYD_GYW_GIS_DATA/GYW-GIS_WGS84/公交站场规划PT.shp";
        //String conceptionKindName = "GYW_BusStation_Plan";
        //String shpFileLocation = "/home/wangychu/Desktop/GYD_GYW_GIS_DATA/GYW-GIS_WGS84/控规2000.shp";
        //String conceptionKindName = "GYW_ControlStipulate";
        //String shpFileLocation = "/home/wangychu/Desktop/GYD_GYW_GIS_DATA/GYW-GIS_WGS84/步行系统.shp";
        //String conceptionKindName = "GYW_PedestrianRoad";
        //String shpFileLocation = "/home/wangychu/Desktop/GYD_GYW_GIS_DATA/GYW-GIS_WGS84/生态城管廊.shp";
        //String conceptionKindName = "GYW_PipeGallery";
        //String shpFileLocation = "/home/wangychu/Desktop/GYD_GYW_GIS_DATA/GYW-GIS_WGS84/生态城范围.shp";
        //String conceptionKindName = "GYW_PlanningScope";
        //String shpFileLocation = "/home/wangychu/Desktop/GYD_GYW_GIS_DATA/GYW-GIS_WGS84/生态城集中供冷供热规划分区�?shp";
        //String conceptionKindName = "GYW_CentralCoolingAndHeatingDistrict_Plan";
        //String shpFileLocation = "/home/wangychu/Desktop/GYD_GYW_GIS_DATA/GYW-GIS_WGS84/轨道线网规划LN.shp";
        //String conceptionKindName = "GYW_RailNetwork_Plan";
        //String shpFileLocation = "/home/wangychu/Desktop/GYD_GYW_GIS_DATA/GYW-GIS_WGS84/轮渡码头规划PT.shp";
        //String conceptionKindName = "GYW_FerryTerminal_Plan";
        //String shpFileLocation = "/home/wangychu/Desktop/GYD_GYW_GIS_DATA/GYW-GIS_WGS84/道路中心�?shp";
        //String conceptionKindName = "GYW_RoadCenterLine_Plan";
        //doSHPImport(shpFileLocation,conceptionKindName);
    }

    private static void doSHPImport(String shpFileLocation,String conceptionKindName) throws EngineServiceRuntimeException, FactoryException, IOException {
        String pathName = shpFileLocation;
        File file = new File(pathName);
        SHP_DataSourceImport.importSHPDataToConceptionKind(conceptionKindName,true,file,null);
    }
}
