package com.sbnvw.artemis.animal_kingdom.treeOfLife.factorys;

import com.sbnvw.artemis.managers.Observer;
import java.util.List;

/**
 *
 * @author Marcel van Wilgenburg
 */
public interface Factory extends Observer {

    @Override
    void update();

}
