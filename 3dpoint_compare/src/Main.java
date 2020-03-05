import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Point implements Comparable<Point> {
    double x, y, z;
    Point(){
        this.x = 0;
        this.y = 0;
        this.z = 0;
    }
    Point(double xx,double yy,double zz){
        this.x = xx;
        this.y = yy;
        this.z = zz;
    }
    double dis(Point p){
        return Math.sqrt((this.x-p.x)*(this.x-p.x) + (this.y-p.y)* (this.y-p.y) + (this.z-p.z)*(this.z-p.z) );
    }
    double dis0(){
        return Math.sqrt(x*x+y*y+z*z);
    }
    @Override
    public int compareTo(Point o) {
        if(dis0() > o.dis0()) return 1;
        if(dis0() < o.dis0()) return -1;
        return 0;
    }
    @Override
    public String toString() {
        return "(" + x +", " + y +", " + z +")";
    }
    
}
class mySort implements Comparator<Point>{

    @Override
    public int compare(Point o1, Point o2) {
        if(o1.x > o2.x) return 1;
        if(o1.x < o2.x) return -1;
        return 0;
    }

}
public class Main {
    public static void main(String[] args) throws Exception {
        ArrayList<Point> al = new ArrayList<Point>();
        al.add(new Point(1,2,3));
        al.add(new Point(9,6,7));
        al.add(new Point(2,7,8));
        al.add(new Point(6,1,9));
        al.add(new Point(6,7,4));
        System.out.println(al + "unSort");
        Collections.sort(al);
        System.out.println(al + "Sort by distence to 0");
        al.sort(new mySort());
        System.out.println(al + "Sort by x");

    }
}