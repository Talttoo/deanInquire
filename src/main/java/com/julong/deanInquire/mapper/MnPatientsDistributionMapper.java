package com.julong.deanInquire.mapper;

import com.julong.deanInquire.dto.entity.mn.MnPatientsDistributionDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 医疗动态
 */
@Mapper
public interface MnPatientsDistributionMapper {

    /**
     * 在院病人分布情况
     * @return
     */
    @Select("select \n" +
            "\t(select deptcode from OM_DEPARTMENT where deptid = a.deptid) as deptCode ,\n" +
            "\t(select deptname from OM_DEPARTMENT where deptid = a.deptid) as deptName ,\n" +
            "\tcount(1) as inTimes\n" +
            "from PA_IP_DATA_WARDPATIENT a\n" +
            "where a.OUTWAY is null and\n" +
            "\ta.ISCURRENT = '1'\n" +
            "group by a.deptID\n" +
            "order by deptCode\n")
    public List<MnPatientsDistributionDTO> getPatientsDistribution();
}
