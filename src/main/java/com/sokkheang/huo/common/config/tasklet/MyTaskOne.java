package com.sokkheang.huo.common.config.tasklet;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MyTaskOne implements Tasklet {

    boolean status = true;

    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception
    {
        System.out.println("MyTaskOne start..");

        // ... your code
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        DateFormat sdf = new SimpleDateFormat("HH:mm");
        if("15:41".equals(sdf.format(date))) {
            if(status){
                System.err.println("Today is : " + sdf.format(date) + " =====########**********Use By Spring boot batch========");
                status = false;
            }else if(status = false){
                return null;
            }
        }
        // ... your code

        System.out.println("MyTaskOne done..");
        return RepeatStatus.FINISHED;
    }
}