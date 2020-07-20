package com.ashimaFabMonitor.threads;

import com.ashimaFabMonitor.config.FileConfig;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.List;
import java.util.Scanner;

@Component
public class HashCalc implements DisposableBean, Runnable {

    File[] f;
    private Thread thread;
//    Scanner[] in;
    Long[] fileTimeStamps;
    //    private volatile boolean someCondition;

    public HashCalc() {
        try {
            System.out.println("BEAN CREATED : "+ FileConfig.folder);
            this.thread = new Thread(this);
            this.thread.start();

            f = new File[FileConfig.files.size()];
//            in = new Scanner[FileConfig.files.size()];
            fileTimeStamps = new Long[FileConfig.files.size()];

            for(int i = 0 ; i < FileConfig.files.size() ; ++i){
                f[i] = new File(FileConfig.folder,FileConfig.files.get(i));
                System.out.println(f[i].getName()+" initialized!");
                fileTimeStamps[i] = f[i].lastModified();
//                in[i] = new Scanner(f[i]);
            }

        } catch (Exception e){
            e.printStackTrace(System.out);
        }
    }

    @Override
    public void run() {
        while(true){
            try {
                Thread.sleep(1000);
                for(int i = 0 ; i < FileConfig.files.size() ; ++i){
                    if(fileTimeStamps[i] < f[i].lastModified()){
                        System.out.println(f[i].getName()+" modified...");
                        fileTimeStamps[i] = f[i].lastModified();
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void destroy() throws Exception {

    }
}
