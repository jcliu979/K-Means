import java.io.*;
import java.util.*;

public class Main {

    public static int dimensions;
    public static int clusterAmount;
    public static ArrayList<Coord> coordsOriginal;
    public static ArrayList<Coord> coords;
    public static ArrayList<Coord> centers;
    public static ArrayList<Coord> coordsPyramid;
    public static ArrayList<Coord> centersPyramid;
    public static ArrayList<Coord> coordRemoves;
    public static Cluster[] clusters;
    public static int[][] rslt;
    public static String groupings;
    public static int[] count;

    public static void main(String[] args) throws IOException {
        BufferedReader f1 = new BufferedReader(new FileReader("kMeans1.in"));
        BufferedReader f2 = new BufferedReader(new FileReader("kMeans2.in"));
        BufferedReader f3 = new BufferedReader(new FileReader("kMeans3.in"));
        BufferedReader f4 = new BufferedReader(new FileReader("kMeans4.in"));
        BufferedReader f5 = new BufferedReader(new FileReader("kMeans5.in"));
        BufferedReader f6 = new BufferedReader(new FileReader("kMeans6.in"));
        BufferedReader f7 = new BufferedReader(new FileReader("kMeans7.in"));
        BufferedReader f8 = new BufferedReader(new FileReader("kMeans8.in"));
        BufferedReader f9 = new BufferedReader(new FileReader("kMeans9.in"));
        BufferedReader f10 = new BufferedReader(new FileReader("kMeans10.in"));
        BufferedReader f11 = new BufferedReader(new FileReader("kMeans11.in"));
        BufferedReader f12 = new BufferedReader(new FileReader("kMeans12.in"));
        BufferedReader f13 = new BufferedReader(new FileReader("kMeans13.in"));
        BufferedReader f14 = new BufferedReader(new FileReader("kMeans14.in"));
        BufferedReader f15 = new BufferedReader(new FileReader("kMeans15.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("kMeans.out")));

        //coordsOriginal = new ArrayList<>();

        clusterAmount = 3;
        dimensions = 5;
        int totalNums = 190;
        rslt = new int[15][15];
        count = new int[15];

        ArrayList<Double>[] str = new ArrayList[15];

        for(int i = 0; i < 15; i++){
            str[i] = new ArrayList<>();

        }

        for(int i = 0; i < totalNums; i++){
            double test = Double.parseDouble(f10.readLine());
            if(test != 0) {
                str[0].add(Double.parseDouble(f1.readLine()));
                str[1].add(Double.parseDouble(f2.readLine()));
                str[2].add(Double.parseDouble(f3.readLine()));
                str[3].add(Double.parseDouble(f4.readLine()));
                str[4].add(Double.parseDouble(f5.readLine()));
                str[5].add(Double.parseDouble(f6.readLine()));
                str[6].add(Double.parseDouble(f7.readLine()));
                str[7].add(Double.parseDouble(f8.readLine()));
                str[8].add(Double.parseDouble(f9.readLine()));
                str[9].add(test);
                str[10].add(Double.parseDouble(f11.readLine()));
                str[11].add(Double.parseDouble(f12.readLine()));
                str[12].add(Double.parseDouble(f13.readLine()));
                str[13].add(Double.parseDouble(f14.readLine()));
                //str[14].add(Double.parseDouble(f15.readLine()));
            }
            else {
                f1.readLine();
                f2.readLine();
                f3.readLine();
                f4.readLine();
                f5.readLine();
                f6.readLine();
                f7.readLine();
                f8.readLine();
                f9.readLine();
                f11.readLine();
                f12.readLine();
                f13.readLine();
                f14.readLine();
                //f15.readLine();

            }

        }

        Coord a1 = new Coord();
        a1.name = "entropy";
        a1.index = 0;
        for (int i = 0; i < str[0].size(); i++) {
            a1.points.add(str[0].get(i));

        }
        Coord a2 = new Coord();
        a2.name = "blockFreq";
        a2.index = 1;
        for (int i = 0; i < str[0].size(); i++) {
            a2.points.add(str[1].get(i));

        }
        Coord a3 = new Coord();
        a3.name = "cumulativeSums";
        a3.index = 2;
        for (int i = 0; i < str[0].size(); i++) {
            a3.points.add(str[2].get(i));

        }
        Coord a4 = new Coord();
        a4.name = "fft";
        a4.index = 3;
        for (int i = 0; i < str[0].size(); i++) {
            a4.points.add(str[3].get(i));

        }
        Coord a5 = new Coord();
        a5.name = "freq";
        a5.index = 4;
        for (int i = 0; i < str[0].size(); i++) {
            a5.points.add(str[4].get(i));

        }
        Coord a6 = new Coord();
        a6.name = "linComplex";
        a6.index = 5;
        for (int i = 0; i < str[0].size(); i++) {
            a6.points.add(str[5].get(i));

        }
        Coord a7 = new Coord();
        a7.name = "longRun";
        a7.index = 6;
        for (int i = 0; i < str[0].size(); i++) {
            a7.points.add(str[6].get(i));

        }
        Coord a8 = new Coord();
        a8.name = "noTemplate";
        a8.index = 7;
        for (int i = 0; i < str[0].size(); i++) {
            a8.points.add(str[7].get(i));

        }
        Coord a9 = new Coord();
        a9.name = "oTemplate";
        a9.index = 8;
        for (int i = 0; i < str[0].size(); i++) {
            a9.points.add(str[8].get(i));

        }
        Coord a10 = new Coord();
        a10.name = "excursions";
        a10.index = 9;
        for (int i = 0; i < str[0].size(); i++) {
            a10.points.add(str[9].get(i));

        }
        Coord a11 = new Coord();
        a11.name = "REV";
        a11.index = 10;
        for (int i = 0; i < str[0].size(); i++) {
            a11.points.add(str[10].get(i));

        }
        Coord a12 = new Coord();
        a12.name = "rank";
        a12.index = 11;
        for (int i = 0; i < str[0].size(); i++) {
            a12.points.add(str[11].get(i));

        }
        Coord a13 = new Coord();
        a13.name = "runs";
        a13.index = 12;
        for (int i = 0; i < str[0].size(); i++) {
            a13.points.add(str[12].get(i));

        }
        Coord a14 = new Coord();
        a14.name = "serial";
        a14.index = 13;
        for (int i = 0; i < str[0].size(); i++) {
            a14.points.add(str[13].get(i));

        }
        /*Coord a15 = new Coord();
        a15.name = "univ";
        a15.index = 14;
        for (int i = 0; i < str[0].size(); i++) {
            a15.points.add(str[14].get(i));

        }*/
        ArrayList<Coord> printer = new ArrayList<>();
        printer.add(a1);
        printer.add(a2);
        printer.add(a3);
        printer.add(a4);
        printer.add(a5);
        printer.add(a6);
        printer.add(a7);
        printer.add(a8);
        printer.add(a9);
        printer.add(a10);
        printer.add(a11);
        printer.add(a12);
        printer.add(a13);
        printer.add(a14);
        //printer.add(a15);

        for(int run = 0; run < str[0].size()/5; run++) {

            Coord am1 = new Coord();
            am1.name = "entropy";
            am1.index = 0;
            for (int i = 0; i < 5; i++) {
                am1.points.add(str[0].get(i + run*5));

            }
            Coord am2 = new Coord();
            am2.name = "blockfreq";
            am2.index = 1;
            for (int i = 0; i < 5; i++) {
                am2.points.add(str[1].get(i + run*5));

            }
            Coord am3 = new Coord();
            am3.name = "cumsums";
            am3.index = 2;
            for (int i = 0; i < 5; i++) {
                am3.points.add(str[2].get(i + run*5));

            }
            Coord am4 = new Coord();
            am4.name = "fft";
            am4.index = 3;
            for (int i = 0; i < 5; i++) {
                am4.points.add(str[3].get(i + run*5));

            }
            Coord am5 = new Coord();
            am5.name = "freq";
            am5.index = 4;
            for (int i = 0; i < 5; i++) {
                am5.points.add(str[4].get(i + run*5));

            }
            Coord am6 = new Coord();
            am6.name = "lincomplex";
            am6.index = 5;
            for (int i = 0; i < 5; i++) {
                am6.points.add(str[5].get(i + run*5));

            }
            Coord am7 = new Coord();
            am7.name = "longrun";
            am7.index = 6;
            for (int i = 0; i < 5; i++) {
                am7.points.add(str[6].get(i + run*5));

            }
            Coord am8 = new Coord();
            am8.name = "notemplate";
            am8.index = 7;
            for (int i = 0; i < 5; i++) {
                am8.points.add(str[7].get(i + run*5));

            }
            Coord am9 = new Coord();
            am9.name = "otemplate";
            am9.index = 8;
            for (int i = 0; i < 5; i++) {
                am9.points.add(str[8].get(i + run*5));

            }
            Coord am10 = new Coord();
            am10.name = "excursions";
            am10.index = 9;
            for (int i = 0; i < 5; i++) {
                am10.points.add(str[9].get(i + run*5));

            }
            Coord am11 = new Coord();
            am11.name = "REV";
            am11.index = 10;
            for (int i = 0; i < 5; i++) {
                am11.points.add(str[10].get(i + run*5));

            }
            Coord am12 = new Coord();
            am12.name = "rank";
            am12.index = 11;
            for (int i = 0; i < 5; i++) {
                am12.points.add(str[11].get(i + run*5));

            }
            Coord am13 = new Coord();
            am13.name = "runs";
            am13.index = 12;
            for (int i = 0; i < 5; i++) {
                am13.points.add(str[12].get(i + run*5));

            }
            Coord am14 = new Coord();
            am14.name = "serial";
            am14.index = 13;
            for (int i = 0; i < 5; i++) {
                am14.points.add(str[13].get(i + run*5));

            }
            /*Coord am15 = new Coord();
            am15.name = "univ";
            am15.index = 14;
            for (int i = 0; i < 5; i++) {
                am15.points.add(str[14].get(i + run*5));

            }*/

            coordsOriginal = new ArrayList<>();
            coordsOriginal.add(am1);
            coordsOriginal.add(am2);
            coordsOriginal.add(am3);
            coordsOriginal.add(am4);
            coordsOriginal.add(am5);
            coordsOriginal.add(am6);
            coordsOriginal.add(am7);
            coordsOriginal.add(am8);
            coordsOriginal.add(am9);
            coordsOriginal.add(am10);
            coordsOriginal.add(am11);
            coordsOriginal.add(am12);
            coordsOriginal.add(am13);
            coordsOriginal.add(am14);
            //coordsOriginal.add(am15);

            //dimensions = str[0].size();

            clusters = new Cluster[clusterAmount];
            centers = new ArrayList<>();
            coords = new ArrayList<>();
            coordsPyramid = new ArrayList<>();
            centersPyramid = new ArrayList<>();

            for (int j = 0; j < clusterAmount; j++) {
                clusters[j] = new Cluster();

            }

            for (int j = 0; j < coordsOriginal.size(); j++) {
                coords.add(coordsOriginal.get(j));

            }

            int startingCount = coords.size() / 2;

            if (coords.size() % 2 == 1) {
                startingCount++;

            }
            for (int j = 0; j < startingCount; j++) {
                int ind = ((int) (Math.random() * coords.size()));
                coordsPyramid.add(coords.get(ind));
                //coords.remove(ind);

            }

            ArrayList<Coord> c1 = new ArrayList<>();
            for (int j = 0; j < coordsPyramid.size() / 3; j++) {
                c1.add(coordsPyramid.get(j));

            }
            centersPyramid.add(average(c1));

            ArrayList<Coord> c2 = new ArrayList<>();
            for (int j = coordsPyramid.size() / 3; j < (2 * coordsPyramid.size()) / 3; j++) {
                c2.add(coordsPyramid.get(j));

            }
            centersPyramid.add(average(c2));

            ArrayList<Coord> c3 = new ArrayList<>();
            for (int j = (2 * coordsPyramid.size()) / 3; j < coordsPyramid.size(); j++) {
                c3.add(coordsPyramid.get(j));

            }
            centersPyramid.add(average(c3));
            pyramid(" ");
            centers = centersPyramid;
            recurse(" ");

        }

        System.out.println();
        System.out.println();
        System.out.println();
        for(int i = 0; i < 15; i++){
            for(int j = 0; j < 15; j++){
                System.out.print(rslt[i][j] + " ");

            }
            System.out.println();

        }

        for(int run = 0; run < 1000; run++) {

            coordRemoves = new ArrayList<>();
            coordsOriginal = new ArrayList<>();
            coordsOriginal.add(a1);
            coordsOriginal.add(a2);
            coordsOriginal.add(a3);
            coordsOriginal.add(a4);
            coordsOriginal.add(a5);
            coordsOriginal.add(a6);
            coordsOriginal.add(a7);
            coordsOriginal.add(a8);
            coordsOriginal.add(a9);
            coordsOriginal.add(a10);
            coordsOriginal.add(a11);
            coordsOriginal.add(a12);
            coordsOriginal.add(a13);
            coordsOriginal.add(a14);
            //coordsOriginal.add(a15);

            for (int q = 0; q < 5; q++) {

                //dimensions = str[0].size();

                clusters = new Cluster[clusterAmount];
                centers = new ArrayList<>();
                coords = new ArrayList<>();
                coordsPyramid = new ArrayList<>();
                centersPyramid = new ArrayList<>();

                for (int j = 0; j < clusterAmount; j++) {
                    clusters[j] = new Cluster();

                }

                for (int j = 0; j < coordsOriginal.size(); j++) {
                    coords.add(coordsOriginal.get(j));

                }

                int startingCount = coords.size() / 2;

                if (coords.size() % 2 == 1) {
                    startingCount++;

                }
                for (int j = 0; j < startingCount; j++) {
                    int ind = ((int) (Math.random() * coords.size()));
                    coordsPyramid.add(coords.get(ind));
                    //coords.remove(ind);

                }

                ArrayList<Coord> c1 = new ArrayList<>();
                for (int j = 0; j < coordsPyramid.size() / 3; j++) {
                    c1.add(coordsPyramid.get(j));

                }
                centersPyramid.add(average(c1));

                ArrayList<Coord> c2 = new ArrayList<>();
                for (int j = coordsPyramid.size() / 3; j < (2 * coordsPyramid.size()) / 3; j++) {
                    c2.add(coordsPyramid.get(j));

                }
                centersPyramid.add(average(c2));

                ArrayList<Coord> c3 = new ArrayList<>();
                for (int j = (2 * coordsPyramid.size()) / 3; j < coordsPyramid.size(); j++) {
                    c3.add(coordsPyramid.get(j));

                }
                centersPyramid.add(average(c3));
                pyramid(" ");
                centers = centersPyramid;
                recurse(" ");

                String[] groupingInts = groupings.split(" ");

                double max = 0;
                int maxIndext = 0;
                for (int i = 0; i < coordsOriginal.size(); i++) {
                    if (getValue(coordsOriginal.get(i), Integer.parseInt(groupingInts[i])) > max) {
                        max = getValue(coordsOriginal.get(i), Integer.parseInt(groupingInts[i]));
                        maxIndext = i;

                    }

                }
                //System.out.println(coordsOriginal.get(maxIndext).name);
                count[coordsOriginal.get(maxIndext).index]++;
                coordRemoves.add(coordsOriginal.get(maxIndext));
                coordsOriginal.remove(maxIndext);


            }
        }



        for(int i = 0; i < 14; i++){
            System.out.println(count[i]);
            System.out.println(printer.get(i).name);
            System.out.println();

        }


    }

    public static double getValue(Coord c, int clusterNum){
        double gm = 1.0;
        for(int i = 0; i < coordRemoves.size(); i++){
            gm = gm * distance(coordRemoves.get(i), c);

        }
        double div = coordRemoves.size();
        if(div != 0)
            div = 1/div;
        else
            div = 0;
        gm = Math.pow(gm, div);

        //System.out.println(gm);
        Coord cent = average(coordsOriginal);
        double distCent = distance(cent, c);

        double distClu = distance(centers.get(clusterNum), c);
        if(distClu == 0)
            distClu = 1;

        double value = gm*distCent/distClu;


        //System.out.println(distClu);
        //System.out.println(gm * distCent/distClu);

        return value;

    }

    public static Coord average(ArrayList<Coord> c){
        Coord rslt = new Coord();
        for(int i = 0; i < c.get(0).points.size(); i++){
            double addit = 0;
            for(int j = 0; j < c.size(); j++){
                addit += c.get(j).points.get(i);

            }
            addit = addit/c.size();
            rslt.points.add(addit);

        }
        return rslt;

    }

    public static void pyramid(String pastGroupings){
        String newGroupings = "";
        for(int i = 0; i < coordsPyramid.size(); i++){
            Coord ci = coordsPyramid.get(i);
            double minDi = -1;
            int minCent = 0;

            for(int j = 0; j < centersPyramid.size(); j++){
                Coord cj = centersPyramid.get(j);
                double distance = distance(ci,cj);
                if(minDi > distance || minDi == -1){
                    minDi = distance;
                    minCent = j;

                }

            }
            newGroupings += Integer.toString(minCent);
            newGroupings += " ";

        }
        if(pastGroupings.equals(newGroupings)){
            return;

        }
        else {
            String[] clumpNumbers = newGroupings.split(" ");

            ArrayList<Coord> cTemp = new ArrayList<>();

            for(int i = 0; i < centersPyramid.size(); i++){
                ArrayList<Coord> tests = new ArrayList<>();
                for(int j = 0; j < coordsPyramid.size(); j++) {
                    if (Integer.parseInt(clumpNumbers[j]) == i)
                        tests.add(coordsPyramid.get(j));
                }
                if(tests.size() > 0) {
                    Coord ad = average(tests);
                    cTemp.add(ad);
                }

            }
            centersPyramid = cTemp;

        }
        pyramid(newGroupings);

    }

    public static double distance(Coord a, Coord b){
        double d = 0;
        for(int i = 0; i < dimensions; i++){
            d += Math.pow(a.points.get(i) - b.points.get(i), 2);

        }

        d = Math.sqrt(d);
        return d;

    }

    public static void recurse(String pastGroupings){
        String newGroupings = "";
        for(int i = 0; i < coords.size(); i++){
            Coord ci = coords.get(i);
            double minDi = -1;
            int minCent = 0;

            for(int j = 0; j < centers.size(); j++){
                Coord cj = centers.get(j);
                double distance = distance(ci,cj);
                if(minDi > distance || minDi == -1){
                    minDi = distance;
                    minCent = j;

                }

            }
            newGroupings += Integer.toString(minCent);
            newGroupings += " ";

        }
        if(pastGroupings.equals(newGroupings)) {
            //System.out.println(newGroupings);
            String[] str = newGroupings.split(" ");
            for(int i = 0; i < str.length; i++){
                clusters[Integer.parseInt(str[i])].c.add(coords.get(i));
                for(int j = 0; j < str.length; j++){
                    if(str[i].equals(str[j])){
                        rslt[i][j]++;
                        rslt[j][i]++;

                    }

                }

            }
            groupings = newGroupings;
            return;
        }
        else {
            ArrayList<Coord> newCent = new ArrayList<>();
            for(int i = 0; i < centers.size(); i++){
                String[] str = newGroupings.split(" ");
                Coord centTemp = new Coord();

                double placeHold[] = new double[dimensions];

                double count = 0;
                for(int j = 0; j < coords.size(); j++){
                    if(Integer.parseInt(str[j]) == i){
                        count++;
                        for(int k = 0; k < dimensions; k++){
                            placeHold[k] += coords.get(j).points.get(k);

                        }

                    }

                }

                for(int j = 0; j < dimensions; j++){
                    centTemp.points.add(placeHold[j]/count);

                }

                newCent.add(centTemp);

            }
            centers = newCent;
            recurse(newGroupings);
        }

    }

    public static class Cluster{
        public ArrayList<Coord> c;

        Cluster(){
            c = new ArrayList<>();

        }

    }

    public static class Coord{
        public String name;
        public int index;

        public ArrayList<Double> points;

        Coord(){
            points = new ArrayList<>();

        }

    }


}


