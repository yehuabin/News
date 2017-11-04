package com.yhb.news.model;

import java.util.List;

/**
 * Created by smk on 2017/10/25.
 */

public class MeiTuModel {


    /**
     * sidebarSortBySelected : sidebarDateSelected
     * sidebarSortOrderSelected : sidebarDescSelected
     * sortBy : date
     * sortOrder : desc
     * nextPage : 3
     * results : [{"img_id":"MSG8LPKDGR","tags":"Norway,  forest,  mountian,  bridge,  travel,  photo,  color,  amazing,  relax","page_views":470,"downloads":95,"favorites":6,"img_width":6000,"img_height":4000,"adjustedWidth":420,"favorited":false},{"img_id":"VXVWEI7WWL","tags":"norway,  forest,  Mountains ,  amazing view,  Colorful ,  Scandinavia , landscape, nature, river, rapids, trees","page_views":475,"downloads":65,"favorites":3,"img_width":6000,"img_height":4000,"adjustedWidth":420,"favorited":false},{"img_id":"QYNAQQNLS8","tags":"cakes,  candles,  brithday, birthday cake, rainbow cake, multicolor cake","page_views":285,"downloads":60,"favorites":8,"img_width":4941,"img_height":3294,"adjustedWidth":420,"favorited":false},{"img_id":"R9EK2G0ADL","tags":"cakes, cake, birthday cake, birthday, rainbow cake, multicolor cake","page_views":200,"downloads":40,"favorites":4,"img_width":6000,"img_height":4000,"adjustedWidth":420,"favorited":false},{"img_id":"ICLODQJOJA","tags":"venice,  italy,  lights,  canal,  amazing,  view","page_views":335,"downloads":65,"favorites":3,"img_width":6000,"img_height":4000,"adjustedWidth":420,"favorited":false},{"img_id":"LQXXY6L9FO","tags":"Toronto ,  city,  downtown,  Canada,  Ontario,  cntower, waterfront, cityscape, skyline","page_views":230,"downloads":40,"favorites":5,"img_width":4352,"img_height":3264,"adjustedWidth":373,"favorited":false},{"img_id":"JF0XPA1MBL","tags":"california,   lake tahoe,   landscape,   nature,  vacation,  lake,  people,  fun,  umbrella,  beach","page_views":230,"downloads":55,"favorites":2,"img_width":2725,"img_height":1811,"adjustedWidth":421,"favorited":false},{"img_id":"2RTQTEA00I","tags":"footpath,   walking,   person,   street,   commuter,   sunlight,   city,   pedestrian,   beard,   alone,   man,   sidewalk","page_views":220,"downloads":55,"favorites":0,"img_width":6000,"img_height":4004,"adjustedWidth":420,"favorited":false},{"img_id":"KSAMTE8QCG","tags":"reading,   paper,   data,   business,   man,   financial,   information,   sunlight,   corporate,   suit,   beard,   finance,   standing,   wall,   newspaper","page_views":265,"downloads":90,"favorites":2,"img_width":6000,"img_height":4004,"adjustedWidth":420,"favorited":false},{"img_id":"R91YYCQGQV","tags":"calm,   freedom,   location,   beach,   transportation,   travel,   exploration,   travel destination,   life,   serenity,   wellness,   casual,   trip,   place,   expedition,   sand,   sea,   journey,   traveler,   leisure,   tourism,   chill,   relaxation,   destination,   holiday,   resting,   va","page_views":270,"downloads":45,"favorites":2,"img_width":6306,"img_height":4740,"adjustedWidth":373,"favorited":false},{"img_id":"PMIKEYHRSP","tags":"mountain,   freedom,   tranquil scene,   girlfriends,   travel,   recreation,   friends,   nature,   friendship,   girls,   rear view,   peaceful,   check,   recess,   togetherness,   hobby,   leisure,   lake,   tourism,   chill,   women,   young,   holiday,   enjoyment,   traveling,   vacation,   s","page_views":185,"downloads":15,"favorites":0,"img_width":4912,"img_height":4848,"adjustedWidth":284,"favorited":false},{"img_id":"PCEFGS6ZK8","tags":"person,   warm,   glasses,   freedom,   plants,   holidays,   travel,   landscape,   hiking,   adventure,   girl,   nature,   tree,   camping,   woman,   casual,   weekend,   backpack,   traveler,   grass,   camera,   romantic,   hobby,   journey,   tourism,   leisure,   forest,   enjoy,   photo,   ","page_views":210,"downloads":10,"favorites":3,"img_width":6584,"img_height":4912,"adjustedWidth":375,"favorited":false},{"img_id":"RQPNDMEZBE","tags":"phone,   travel,   together,   wanderlust,   caucasian,   friends,   traveling,   friendship,   connection,   journey,   concentrated,   tourism,   leisure,   destination,   sitting,   vacation,   internet,   joy,   holidays,   carefree,   digital,   looking,   modern,   adventure,   casual,   trip,","page_views":300,"downloads":105,"favorites":4,"img_width":7360,"img_height":4912,"adjustedWidth":420,"favorited":false},{"img_id":"QKZ38O0NKX","tags":"calm,   holding,   rocky,   stone,   valley,   travel,   landscape,   recreation,   photography,   attraction,   wanderlust,   mountains,   adventure,   girl,   nature,   serenity,   photographer,   weather,   trip,   pond,   water,   hill,   peaceful,   journey,   tourism,   lake,   leisure,   scen","page_views":520,"downloads":180,"favorites":12,"img_width":7360,"img_height":4912,"adjustedWidth":420,"favorited":false},{"img_id":"EVXTC47ITU","tags":"nature,  trees, leaves, fall","page_views":315,"downloads":95,"favorites":5,"img_width":3008,"img_height":2000,"adjustedWidth":421,"favorited":false},{"img_id":"VFWLORCPSL","tags":"nature,  flower, leaves, spring, bloom","page_views":175,"downloads":30,"favorites":6,"img_width":3008,"img_height":2000,"adjustedWidth":421,"favorited":false},{"img_id":"JSSIH24URA","tags":"apple,  amazing,  photo,  autumn,  canon,  red,  sunny,  garden","page_views":250,"downloads":35,"favorites":1,"img_width":6000,"img_height":4000,"adjustedWidth":420,"favorited":false},{"img_id":"A4YFWEUBK1","tags":"cup,   drinks,   coffee shop,   business,   online,   deal,   laptop,   working,   networking,   connection,   communication,   brainstorming,   agreement,   togetherness,   table,   talking,   corporate,   tablet,   beverage,   planning,   meeting,   beard,   cafe,   internet","page_views":435,"downloads":120,"favorites":3,"img_width":5353,"img_height":3572,"adjustedWidth":420,"favorited":false},{"img_id":"AO1EGLR0H0","tags":"coffee shop,   business,   online,   break,   telecommunication,   mobile phone,   networking,   connection,   togetherness,   interaction,   corporate,   beard,   on the phone,   internet","page_views":240,"downloads":30,"favorites":4,"img_width":6000,"img_height":4122,"adjustedWidth":408,"favorited":false},{"img_id":"Q8C6UCZ2FF","tags":"drinks,   coffee shop,   business,   deal,   connection,   brainstorming,   agreement,   talking,   corporate,   beverage,   planning,   meeting,   beard,   cafe","page_views":365,"downloads":55,"favorites":4,"img_width":6000,"img_height":4004,"adjustedWidth":420,"favorited":false},{"img_id":"JYZPZIZGAG","tags":"networking,   connection,   interaction,   business,   online,   corporate,   telecommunication,   woman,   suit,   mobile phone,   on the phone,   internet","page_views":220,"downloads":40,"favorites":1,"img_width":4004,"img_height":6000,"adjustedWidth":187,"favorited":false},{"img_id":"F1HB0G07TC","tags":"calm,   freedom,   location,   travel,   transportation,   exploration,   travel destination,   life,   woman,   serenity,   wellness,   casual,   trip,   place,   expedition,   traveler,   journey,   tourism,   leisure,   relaxation,   chill,   destination,   holiday,   resting,   vacation,   route","page_views":185,"downloads":35,"favorites":2,"img_width":6442,"img_height":4546,"adjustedWidth":397,"favorited":false},{"img_id":"65XB1QJXKI","tags":"calm,   freedom,   location,   transportation,   travel,   exploration,   travel destination,   life,   woman,   serenity,   wellness,   casual,   backpack,   trip,   place,   expedition,   traveler,   journey,   tourism,   leisure,   chill,   destination,   holiday,   resting,   vacation,   route, ","page_views":285,"downloads":65,"favorites":3,"img_width":7360,"img_height":3968,"adjustedWidth":519,"favorited":false},{"img_id":"ZNGREEZQPI","tags":"shore,   craft,   holding,   paper,   tranquil scene,   ocean,   travel,   beach,   recreation,   hand,   water,   abstract,   icon,   paper craft,   peaceful,   symbol,   art,   sea,   leisure,   frame,   traveling,   vacation,   serene,   peace,   perforated,   summer,   rest","page_views":510,"downloads":190,"favorites":22,"img_width":4879,"img_height":4329,"adjustedWidth":316,"favorited":false},{"img_id":"TIYYJJ0K0I","tags":"cup,   freedom,   travel,   together,   hiking,   friends,   tree,   nature,   camping,   weekend,   friendship,   grass,   hobby,   journey,   lake,   tourism,   forest,   leisure,   lens,   holiday,   tourist,   backpacker,   voyage,   shoot,   outdoors,   warm,   plants,   holidays,   landscape, ","page_views":205,"downloads":25,"favorites":0,"img_width":6119,"img_height":4155,"adjustedWidth":412,"favorited":false},{"img_id":"881NMYT0S0","tags":"person,   holding,   joy,   holidays,   carefree,   travel,   landscape,   caucasian,   wanderlust,   mountains,   adventure,   girl,   nature,   side,   woman,   casual,   trip,   water,   rear,   back,   journey,   tourism,   leisure,   lake,   enjoy,   scenic,   young,   destination,   hands up, ","page_views":255,"downloads":50,"favorites":2,"img_width":7094,"img_height":4912,"adjustedWidth":404,"favorited":false},{"img_id":"CX0T1DOOAU","tags":"technology,   girlfriends,   online,   sharing,   friends,   social,   friendship,   mobile phone,   girls,   networking,   connection,   togetherness,   women,   sitting,   internet, phones, texting","page_views":230,"downloads":45,"favorites":8,"img_width":5169,"img_height":4231,"adjustedWidth":342,"favorited":false},{"img_id":"TD0ZOMAYHJ","tags":"workplace,  desk,  feminine,  notes,  notebooks,  diary,  pens,  pink cup,  pink diary,  gold diary,  striped diary,  dahlia,  flowers,  paper clip,  pink paper clip,  girly,  purple,  pink,  gold,  golden,  white background,  flat lay,  cup of coffee,  turquoise,  red dahlia,  pocketbook,  write","page_views":625,"downloads":225,"favorites":25,"img_width":5184,"img_height":3456,"adjustedWidth":420,"favorited":false},{"img_id":"FFVIMFMAM0","tags":"girl,  blonde,  photographer,  photography,  photo,  camera,  lens,  Sony,  Canon,  cute,  female,  woman,  nature,  trail,  hiking,  hike,  denim","page_views":220,"downloads":10,"favorites":2,"img_width":4480,"img_height":6720,"adjustedWidth":187,"favorited":false},{"img_id":"ZKBPKSFZ7I","tags":"Snow,  winter,  snowing,  canyon,  Athabasca,  waterfalls,  waterfall,  glacier,  water,  stream,  lake,  river,  forest,  trees,  tree","page_views":405,"downloads":160,"favorites":18,"img_width":6720,"img_height":4480,"adjustedWidth":420,"favorited":false},{"img_id":"Q7STENMU1K","tags":"waterfall,  nature,  earth,  cave,  water,  canyon,  beautiful,  falls,  fall","page_views":345,"downloads":90,"favorites":12,"img_width":6720,"img_height":4480,"adjustedWidth":420,"favorited":false},{"img_id":"YGYQA2V3TT","tags":"mountains,  mountain,  sunset,  lake,  water,  rocks,  scenery,  landscape,  dusk","page_views":215,"downloads":50,"favorites":14,"img_width":3605,"img_height":5408,"adjustedWidth":187,"favorited":false},{"img_id":"XOIKTG7EVX","tags":"walking,  girl,  blonde,  nature,  earth,  female,  beanie,  fall,  cold,  blanket,  explore,  travel,  lake,  sky,  sunset","page_views":175,"downloads":20,"favorites":14,"img_width":4065,"img_height":6098,"adjustedWidth":187,"favorited":false},{"img_id":"VNQAHDPC8T","tags":"fruits,  vegetables,  vegetable,  yellow pepper,  red pepper,  fruit,  pepper,  water,  splash","page_views":295,"downloads":95,"favorites":8,"img_width":3530,"img_height":2353,"adjustedWidth":420,"favorited":false},{"img_id":"B7B0MWLTLW","tags":"girl,  blonde,  cute,  pretty,  landscape,  earth,  ottawa,  ontario,  travel,  forest,  fall,  photographer,  photograph,  camera,  canon,  lens,  cliff,  female,  woman,  lady,  lake,  water,  nature","page_views":130,"downloads":25,"favorites":2,"img_width":3887,"img_height":5830,"adjustedWidth":187,"favorited":false},{"img_id":"CK9HGEDRPV","tags":"thanksgiving,  fall,  weather,  pumpkins,  pumpkin,  halloween,  festive,  porch,  pilgrims,  pilgrimage ","page_views":380,"downloads":110,"favorites":20,"img_width":5008,"img_height":3339,"adjustedWidth":420,"favorited":false},{"img_id":"IZJKSG1FLK","tags":"walking,  city,  girl,  female,  woman,  blonde,  dress,  purse,  travel,  explore","page_views":290,"downloads":120,"favorites":18,"img_width":4992,"img_height":3328,"adjustedWidth":420,"favorited":false},{"img_id":"STOEXJCASE","tags":"business,  waiting,  impatient,  patient,  watch,  indian,  male,  man,  guy,  person,  boy,  tie,  dress shirt,  brick wall,  casual","page_views":325,"downloads":140,"favorites":5,"img_width":3444,"img_height":2296,"adjustedWidth":420,"favorited":false},{"img_id":"ASM6PGRK5O","tags":"boardwalk,  travel,  road,  path,  traveling,  Yellowstone,  hot springs,  National Park,  Montana","page_views":290,"downloads":35,"favorites":12,"img_width":4687,"img_height":2827,"adjustedWidth":464,"favorited":false},{"img_id":"T23T6PWH3D","tags":"morning,  sunrise,  foggy,  early,  landscape,  mist,  Yellowstone,  National Park,  earth,  travel,  nature,  mountains,  lake,  water","page_views":165,"downloads":70,"favorites":9,"img_width":5472,"img_height":3648,"adjustedWidth":420,"favorited":false}]
     */

    private String sidebarSortBySelected;
    private String sidebarSortOrderSelected;
    private String sortBy;
    private String sortOrder;
    private int nextPage;
    private List<ResultsBean> results;

    public String getSidebarSortBySelected() {
        return sidebarSortBySelected;
    }

    public void setSidebarSortBySelected(String sidebarSortBySelected) {
        this.sidebarSortBySelected = sidebarSortBySelected;
    }

    public String getSidebarSortOrderSelected() {
        return sidebarSortOrderSelected;
    }

    public void setSidebarSortOrderSelected(String sidebarSortOrderSelected) {
        this.sidebarSortOrderSelected = sidebarSortOrderSelected;
    }

    public String getSortBy() {
        return sortBy;
    }

    public void setSortBy(String sortBy) {
        this.sortBy = sortBy;
    }

    public String getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(String sortOrder) {
        this.sortOrder = sortOrder;
    }

    public int getNextPage() {
        return nextPage;
    }

    public void setNextPage(int nextPage) {
        this.nextPage = nextPage;
    }

    public List<ResultsBean> getResults() {
        return results;
    }

    public void setResults(List<ResultsBean> results) {
        this.results = results;
    }

    public static class ResultsBean {
        /**
         * img_id : MSG8LPKDGR
         * tags : Norway,  forest,  mountian,  bridge,  travel,  photo,  color,  amazing,  relax
         * page_views : 470
         * downloads : 95
         * favorites : 6
         * img_width : 6000
         * img_height : 4000
         * adjustedWidth : 420
         * favorited : false
         */

        private String img_id;
        private String tags;
        private int page_views;
        private int downloads;
        private int favorites;
        private int img_width;
        private int img_height;
        private int adjustedWidth;
        private boolean favorited;

        public String getImg_id() {
            return img_id;
        }

        public void setImg_id(String img_id) {
            this.img_id = img_id;
        }

        public String getTags() {
            return tags;
        }

        public void setTags(String tags) {
            this.tags = tags;
        }

        public int getPage_views() {
            return page_views;
        }

        public void setPage_views(int page_views) {
            this.page_views = page_views;
        }

        public int getDownloads() {
            return downloads;
        }

        public void setDownloads(int downloads) {
            this.downloads = downloads;
        }

        public int getFavorites() {
            return favorites;
        }

        public void setFavorites(int favorites) {
            this.favorites = favorites;
        }

        public int getImg_width() {
            return img_width;
        }

        public void setImg_width(int img_width) {
            this.img_width = img_width;
        }

        public int getImg_height() {
            return img_height;
        }

        public void setImg_height(int img_height) {
            this.img_height = img_height;
        }

        public int getAdjustedWidth() {
            return adjustedWidth;
        }

        public void setAdjustedWidth(int adjustedWidth) {
            this.adjustedWidth = adjustedWidth;
        }

        public boolean isFavorited() {
            return favorited;
        }

        public void setFavorited(boolean favorited) {
            this.favorited = favorited;
        }
    }
}

