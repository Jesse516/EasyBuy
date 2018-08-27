package org.crm.service;

import org.crm.domain.BasActivity;
import org.crm.util.BasPageUtil;

import java.util.List;

public interface BasActivityService {
    public List<BasActivity> findAllPage(BasPageUtil basPageUtil);
    public int countBasActivity(BasPageUtil basPageUtil);
    public int countPage(BasPageUtil basPageUtil);
    public BasActivity findById(int dict_id);
    public int updateBas(BasActivity basActivity);
    public int delBas(int dict_id);
    public int addBas(BasActivity basActivity);
}
