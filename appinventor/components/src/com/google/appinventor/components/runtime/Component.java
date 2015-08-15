// -*- mode: java; c-basic-offset: 2; -*-
// Copyright 2009-2011 Google, All Rights reserved
// Copyright 2011-2012 MIT, All rights reserved
// Released under the Apache License, Version 2.0
// http://www.apache.org/licenses/LICENSE-2.0

package com.google.appinventor.components.runtime;

import com.google.appinventor.components.annotations.SimpleObject;
import com.google.appinventor.components.common.ComponentConstants;

/**
 * Interface for Simple components.
 *
 */
@SimpleObject
public interface Component {
  /**
   * Returns the dispatch delegate that is responsible for dispatching events
   * for this component.
   */
  public HandlesEventDispatching getDispatchDelegate();

  /*
   * Components asset directory.
   */
  public static final String ASSET_DIRECTORY = "component";

  /*
   * Text alignment constants.
   */
  static final int ALIGNMENT_NORMAL = 0;
  static final int ALIGNMENT_CENTER = 1;
  static final int ALIGNMENT_OPPOSITE = 2;

  /*
   * Accelerometer sensitivity.
   */
  static final int ACCELEROMETER_SENSITIVITY_WEAK = 1;
  static final int ACCELEROMETER_SENSITIVITY_MODERATE = 2;
  static final int ACCELEROMETER_SENSITIVITY_STRONG = 3;

  /*
   * Button Styles.
   */
  static final int BUTTON_SHAPE_DEFAULT = 0;
  static final int BUTTON_SHAPE_ROUNDED = 1;
  static final int BUTTON_SHAPE_RECT = 2;
  static final int BUTTON_SHAPE_OVAL = 3;

  /*
   * Color constants.
   */
  static final int COLOR_NONE = 0x00FFFFFF;
  static final int COLOR_BLACK = 0xFF000000;
  static final int COLOR_BLUE = 0xFF0000FF;
  static final int COLOR_CYAN = 0xFF00FFFF;
  static final int COLOR_DKGRAY = 0xFF444444;
  static final int COLOR_GRAY = 0xFF888888;
  static final int COLOR_GREEN = 0xFF00FF00;
  static final int COLOR_LTGRAY = 0xFFCCCCCC;
  static final int COLOR_MAGENTA = 0xFFFF00FF;
  static final int COLOR_ORANGE = 0xFFFFC800;
  static final int COLOR_PINK = 0xFFFFAFAF;
  static final int COLOR_RED = 0xFFFF0000;
  static final int COLOR_WHITE = 0xFFFFFFFF;
  static final int COLOR_YELLOW = 0xFFFFFF00;
  static final int COLOR_DEFAULT = 0x00000000;

  static final String DEFAULT_VALUE_COLOR_NONE = "&H00FFFFFF";
  static final String DEFAULT_VALUE_COLOR_BLACK = "&HFF000000";
  static final String DEFAULT_VALUE_COLOR_BLUE = "&HFF0000FF";
  static final String DEFAULT_VALUE_COLOR_CYAN = "&HFF00FFFF";
  static final String DEFAULT_VALUE_COLOR_DKGRAY = "&HFF444444";
  static final String DEFAULT_VALUE_COLOR_GRAY = "&HFF888888";
  static final String DEFAULT_VALUE_COLOR_GREEN = "&HFF00FF00";
  static final String DEFAULT_VALUE_COLOR_LTGRAY = "&HFFCCCCCC";
  static final String DEFAULT_VALUE_COLOR_MAGENTA = "&HFFFF00FF";
  static final String DEFAULT_VALUE_COLOR_ORANGE = "&HFFFFC800";
  static final String DEFAULT_VALUE_COLOR_PINK = "&HFFFFAFAF";
  static final String DEFAULT_VALUE_COLOR_RED = "&HFFFF0000";
  static final String DEFAULT_VALUE_COLOR_WHITE = "&HFFFFFFFF";
  static final String DEFAULT_VALUE_COLOR_YELLOW = "&HFFFFFF00";
  static final String DEFAULT_VALUE_COLOR_DEFAULT = "&H00000000";

  /*
   * Font constants.
   */
  static final float FONT_DEFAULT_SIZE = 14;

  /*
   * Layout constants.
   */
  static final int LAYOUT_ORIENTATION_HORIZONTAL = ComponentConstants.LAYOUT_ORIENTATION_HORIZONTAL;
  static final int LAYOUT_ORIENTATION_VERTICAL = ComponentConstants.LAYOUT_ORIENTATION_VERTICAL;

  /*
   * Typeface constants.
   */
  static final int TYPEFACE_DEFAULT = 0;
  static final int TYPEFACE_SANSSERIF = 1;
  static final int TYPEFACE_SERIF = 2;
  static final int TYPEFACE_MONOSPACE = 3;

  /*
   * Length constants (for width and height).
   */
  static final int LENGTH_PREFERRED = -1;
  static final int LENGTH_FILL_PARENT = -2;
  static final int LENGTH_UNKNOWN = -3;

  /*
   * Length constants for toast.
   */
  static final int TOAST_LENGTH_SHORT = 0;
  static final int TOAST_LENGTH_LONG = 1;

  /*
   * Screen direction constants.
   * Observe that opposite directions have the same magnitude but opposite signs.
   */
  static final int DIRECTION_NORTH = 1;
  static final int DIRECTION_NORTHEAST = 2;
  static final int DIRECTION_EAST = 3;
  static final int DIRECTION_SOUTHEAST = 4;
  static final int DIRECTION_SOUTH = -1;
  static final int DIRECTION_SOUTHWEST = -2;
  static final int DIRECTION_WEST = -3;
  static final int DIRECTION_NORTHWEST = -4;
  // Special values
  static final int DIRECTION_NONE = 0;
  static final int DIRECTION_MIN = -4;
  static final int DIRECTION_MAX = 4;

  //Slider defaults for setting MinimumValue and MaximumValue
  public static float SLIDER_MIN_VALUE = 10;
  public static float SLIDER_MAX_VALUE = 50;
  public static float SLIDER_THUMB_VALUE = (SLIDER_MIN_VALUE + SLIDER_MAX_VALUE) / 2.0f;

  static final String DEFAULT_VALUE_TEXT_TO_SPEECH_COUNTRY = "USA";
  static final String DEFAULT_VALUE_TEXT_TO_SPEECH_LANGUAGE = "en";

  static final int MENU_NO_ICON = 0;
  static final int MENU_ADD = 1;
  static final int MENU_AGENDA = 2;
  static final int MENU_ALWAYS_LANDSCAPE_PORTRAIT = 3;
  static final int MENU_CALL = 4;
  static final int MENU_CAMERA = 5;
  static final int MENU_CLOSE_CLEAR_CANCEL = 6;
  static final int MENU_COMPASS = 7;
  static final int MENU_CROP = 8;
  static final int MENU_DAY = 9;
  static final int MENU_DELETE = 10;
  static final int MENU_DIRECTIONS = 11;
  static final int MENU_EDIT = 12;
  static final int MENU_GALLERY = 13;
  static final int MENU_HELP = 14;
  static final int MENU_INFO_DETAILS = 15;
  static final int MENU_MANAGE = 16;
  static final int MENU_MAPMODE = 17;
  static final int MENU_MONTH = 18;
  static final int MENU_MORE = 19;
  static final int MENU_MY_CALENDAR = 20;
  static final int MENU_MYLOCATION = 21;
  static final int MENU_MYPLACES = 22;
  static final int MENU_PREFERENCES = 23;
  static final int MENU_RECENT_HISTORY = 24;
  static final int MENU_REPORT_IMAGE = 25;
  static final int MENU_REVERT = 26;
  static final int MENU_ROTATE = 27;
  static final int MENU_SAVE = 28;
  static final int MENU_SEARCH = 29;
  static final int MENU_SEND = 30;
  static final int MENU_SET_AS = 31;
  static final int MENU_SHARE = 32;
  static final int MENU_SLIDESHOW = 33;
  static final int MENU_SORT_ALPHABETICALLY = 34;
  static final int MENU_SORT_BY_SIZE = 35;
  static final int MENU_TODAY = 36;
  static final int MENU_UPLOAD = 37;
  static final int MENU_UPLOAD_YOU_TUBE = 38;
  static final int MENU_VIEW = 39;
  static final int MENU_WEEK = 40;
  static final int MENU_ZOOM = 41;
}
