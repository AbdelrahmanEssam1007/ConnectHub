package backend;

import java.util.List;

public  final class RefreshManager {
    private final List<Refreshable> refreshableList;

    public RefreshManager(List<Refreshable> refreshableList) {
        this.refreshableList = refreshableList;
    }

    public void refreshAll(){
        for(Refreshable item : refreshableList){
            item.refresh();
        }
    }
}
