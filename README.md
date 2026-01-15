# D3A - Data Analysis & AI Algorithm Platform

> Development Guide

## Overview

D3A platform is built on Domain-Driven Design principles. It's a comprehensive data analysis toolkit centered around graph data analysis, AI algorithms, and in-memory real-time computing technology. The platform enables highly complex data analysis tasks from a business-oriented perspective by combining relationship analysis, temporal analysis, and geospatial (GIS) analysis capabilities.

---

## Core Concepts

The D3A platform uses the following terms to model business domains:

### **Type**
Conceptual types define any real or logical concept in a domain model. They include attribute view types and relationship attachment rules.

### **Entity**
A conceptual entity is a concrete data representation of a specific type, representing either a real-world object or a logical concept.

### **Attribute**
Defines the structure of data information within a conceptual type, including name, description, and data type.

### **AttributesView**
A container that groups multiple attributes together, describing a specific category of information for a conceptual type.

### **RelationshipType**
Describes how conceptual entities associate with each other (e.g., spatial containment or logical dependency).

### **RelationshipEntity**
A concrete instance of a relationship type, representing an actual association between two entities.

### **RelationshipAttachmentRule**
Execution rules for linking entities of two specific conceptual types.

### **Classification**
Non-domain-specific dictionary concepts (e.g., gender, race, building types) used for multidimensional data analysis.

### **TimeFlow**
Represents a continuous period of time composed of various time interval entities, enabling temporal analysis.

### **TimeScaleEntity**
A specific point or range in time (day, hour, minute) used to organize and analyze temporal data.

### **TimeScaleEvent**
Connects an entity to a specific point in time to describe time-related business information.

### **Geospatial**
Represents a geographical area with multiple administrative division levels for spatial analysis.

### **GeospatialScaleEntity**
A specific administrative region (country, city, street) used for geospatial analysis.

### **GeospatialScaleEvent**
Connects an entity to a specific geographic location for spatial analysis.

---

## Architecture

### Core Realm Scope
![D3A Core Architecture](documentPic/coreRealmScope_new.png)

---

## Example Domain Models

### Underground Pipeline Network
- **Entities**: PipePoint (9,696), PipeTubulation (9,281)
- **Relationships**: connectTo (17,044)

![Pipeline Network](documentPic/graph_UndergroundPipelineNetworkRealm.png)

**Generator Class:**
```java
com.github.d3a.realmExample.UndergroundPipelineNetwork_Realm_Generator
```

---

### Song Playlists
- **Entities**: Song (9,775), MusicTag (250), Playlist (188,064)
- **Relationships**: playedInList (1,790,143), belongsToMusicType (149,041)

![Song Playlists](documentPic/graph_SongPlaylistsRealm.png)

**Generator Class:**
```java
com.github.d3a.realmExample.SongPlaylists_Realm_Generator
```

---

### Seattle Fire 911 Calls
- **Entities**: Fire911Call (1,471,980)
- **Time Events**: occurredAt (1,471,980)

![Fire 911 Calls](documentPic/graph_SeattleRealTimeFire911CallsRealm.png)

**Generator Class:**
```java
com.github.d3a.realmExample.SeattleRealTimeFire911Calls_Realm_Generator
```

---

### Road Weather Information
- **Entities**: RoadWeatherRecords (1,790,049)
- **Time Events**: recordedAt (1,790,049)

![Weather Records](documentPic/graph_RoadWeatherInformationStationsRecordsRealm.png)

**Generator Class:**
```java
com.github.d3a.realmExample.RoadWeatherInformationStationsRecords_Realm_Generator
```

---

### Island Geospatial Data
- **Entities**: IndividualTree, Frutex, FunctionalZone, SectionBlock, Road, Building, ConstructionLand
- **Analysis**: Full geospatial data analysis capabilities

![Island GeoData](documentPic/graph_Island_GeoDataRealm.png)

**Generator Class:**
```java
com.github.d3a.realmExample.Island_GeoData_Realm_Generator
```

---

## Platform Architecture

![System Architecture](documentPic/sysStructure_new.png)