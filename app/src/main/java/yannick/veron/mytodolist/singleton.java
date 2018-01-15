package yannick.veron.mytodolist;

import java.util.ArrayList;

/**
 * Created by verony on 15/01/2018.
 */
public class Singleton
{

        private static volatile Singleton instance = null;




    private ArrayList<String> data = new ArrayList<String>();

    public ArrayList<String> getData() {
        return data;
    }
    public void setData(String data) {
        this.data.add(data);
    }


        private Singleton() {
            super();
        }


        public final static Singleton getInstance() {
            if (Singleton.instance == null)
            {
                synchronized(Singleton.class) {
                    if (Singleton.instance == null) {
                        Singleton.instance = new Singleton();
                    }
                }
            }
            return Singleton.instance;
        }


}


