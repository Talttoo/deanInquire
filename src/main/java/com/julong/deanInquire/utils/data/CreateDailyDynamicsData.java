package com.julong.deanInquire.utils.data;

import com.julong.deanInquire.dto.entity.dean.DeClDailyDynamicsDTO;
import com.julong.deanInquire.dto.entity.dean.DeClWaitingQueueDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * 为减少前端工作，进一步封装每日动态数据
 */
@Component
public class CreateDailyDynamicsData {

    public  List<DeClDailyDynamicsDTO>  createData( List<DeClDailyDynamicsDTO> list){
        List<DeClDailyDynamicsDTO> myList = new  ArrayList();
        //初始化24小时的数据
        for(int i=0;i<24;i++){
            DeClDailyDynamicsDTO  deClDailyDynamicsDTO = new DeClDailyDynamicsDTO();
            if(i<10) {
                deClDailyDynamicsDTO.setHour("0"+i);
            }else{
                deClDailyDynamicsDTO.setHour(i+"");
            }
            deClDailyDynamicsDTO.setGopTimes("");
            deClDailyDynamicsDTO.setErTimes("");
            myList.add(deClDailyDynamicsDTO);
        }
        //根据数据库数据更改初始化的数据
        for(int j = 0 ; j < list.size() ; j++) {
            int  hour = Integer.parseInt(list.get(j).getHour());
            myList.get(hour).setErTimes(list.get(j).getErTimes());
            myList.get(hour).setGopTimes(list.get(j).getGopTimes());
        }

        return myList;
    }

    public List<String> getClData(List<DeClDailyDynamicsDTO> list){
        List<String> myList = new  ArrayList();

        for(int j = 0 ; j < list.size() ; j++) {
            myList.add(j,list.get(j).getGopTimes());
        }

        return  myList;
    }

    public List<String> getEmData(List<DeClDailyDynamicsDTO> list){
        List<String> myList = new  ArrayList();

        for(int j = 0 ; j < list.size() ; j++) {
            myList.add(j,list.get(j).getErTimes());
        }
        return  myList;
    }

    public List<DeClWaitingQueueDTO> createWaitQueue() {
        List<DeClWaitingQueueDTO> myList = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            DeClWaitingQueueDTO deClWaitingQueueDTO = new DeClWaitingQueueDTO();
            deClWaitingQueueDTO.setRowNo(1);
            deClWaitingQueueDTO.setQueueId("00"+i);
            deClWaitingQueueDTO.setRecipeId("100"+i);
            deClWaitingQueueDTO.setName("李"+i);
            deClWaitingQueueDTO.setWinCode("000"+i);
            deClWaitingQueueDTO.setWinName(i+"号窗口");
            myList.add(deClWaitingQueueDTO);

        }
        return myList;
    }
}
