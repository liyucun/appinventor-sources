package com.google.appinventor.client.editor.youngandroid.properties;

import static com.google.appinventor.client.Ode.MESSAGES;
import com.google.appinventor.client.widgets.properties.ChoicePropertyEditor;

public class YoungAndroidSimpleMenuItemIconChoicePropertyEditor extends ChoicePropertyEditor {

    private static final Choice[] menuIcons = new Choice[] {
            new Choice(MESSAGES.noMenuIcon(), "0"),
            new Choice(MESSAGES.addMenuIcon() , "1"),
            new Choice(MESSAGES.agendaMenuIcon(), "2"),
            new Choice(MESSAGES.alwaysLandscapePortraitMenuIcon(), "3"),
            new Choice(MESSAGES.callMenuIcon(), "4"),
            new Choice(MESSAGES.cameraMenuIcon(), "5"),
            new Choice(MESSAGES.closeClearCancelMenuIcon(), "6"),
            new Choice(MESSAGES.compassMenuIcon(), "7"),
            new Choice(MESSAGES.cropMenuIcon(), "8"),
            new Choice(MESSAGES.dayMenuIcon(), "9"),
            new Choice(MESSAGES.deleteMenuIcon(), "10"),
            new Choice(MESSAGES.directionsMenuIcon(), "11"),
            new Choice(MESSAGES.editMenuIcon(), "12"),
            new Choice(MESSAGES.galleryMenuIcon(), "13"),
            new Choice(MESSAGES.helpMenuIcon(), "14"),
            new Choice(MESSAGES.infoDetailsMenuIcon(), "15"),
            new Choice(MESSAGES.manageMenuIcon(), "16"),
            new Choice(MESSAGES.mapmodeMenuIcon(), "17"),
            new Choice(MESSAGES.monthMenuIcon(), "18"),
            new Choice(MESSAGES.moreMenuIcon(), "19"),
            new Choice(MESSAGES.myCalendarMenuIcon(), "20"),
            new Choice(MESSAGES.mylocatinoMenuIcon(), "21"),
            new Choice(MESSAGES.myplacesMenuIcon(), "22"),
            new Choice(MESSAGES.preferencesMenuIcon(), "23"),
            new Choice(MESSAGES.recentHistoryMenuIcon(), "24"),
            new Choice(MESSAGES.reportImageMenuIcon(), "25"),
            new Choice(MESSAGES.revertMenuIcon(), "26"),
            new Choice(MESSAGES.rotateMenuIcon(), "27"),
            new Choice(MESSAGES.saveMenuIcon(), "28"),
            new Choice(MESSAGES.searchMenuIcon(), "29"),
            new Choice(MESSAGES.sendMenuIcon(), "30"),
            new Choice(MESSAGES.setasMenuIcon(), "31"),
            new Choice(MESSAGES.shareMenuIcon(), "32"),
            new Choice(MESSAGES.slideshowMenuIcon(), "33"),
            new Choice(MESSAGES.sortAlphabeticallyMenuIcon(), "34"),
            new Choice(MESSAGES.sortBySizeMenuIcon(), "35"),
            new Choice(MESSAGES.todayMenuIcon(), "36"),
            new Choice(MESSAGES.uploadMenuIcon(), "37"),
            new Choice(MESSAGES.uploadYoutubeMenuIcon(), "38"),
            new Choice(MESSAGES.viewMenuIcon(), "39"),
            new Choice(MESSAGES.weekMenuIcon(), "40"),
            new Choice(MESSAGES.zoomMenuIcon(), "41")
    };

    public YoungAndroidSimpleMenuItemIconChoicePropertyEditor() {
        super(menuIcons);
    }
}