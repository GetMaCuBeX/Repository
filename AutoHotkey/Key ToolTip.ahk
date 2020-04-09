; =========================================================================================== [OPTIONS]
#Include %A_ScriptDir%\\Script\Options.ahk
; =========================================================================================== [FUNCTION] [TOOLTIP]
#Include %A_ScriptDir%\\Script\ToolTip.ahk
@ToolTipTimeOut_Specify_Global = -4000  ; Re-Assign value for Specified TimeOut
@ToolTipTimeOut_Default_Global = -1000  ; Re-Assign value for Default TimeOut
; =========================================================================================== [VARIABLES]
; =========================================================================================== [FILES]
Return
; =========================================================================================== [OPTIONS] [RETURN]

; =========================================================================================== [HOTKEY] [REMOVE TOOLTIP WHEN MOUSE CLICK]
~RButton::
ToolTip
Return
~LButton::
ToolTip
Return
; =========================================================================================== [HOTKEY] [DISPLAY TOOLTIP]
Numpad1::
RunTollTipHotkeyInfo("Display ToolTip `nTimeout Default: "@ToolTipTimeOut_Default_Global "ms")
Return
Numpad2::
RunTollTipHotkeyInfo("Display ToolTip `nTimeout Specify: "@ToolTipTimeOut_Specify_Global "ms" 	, @ToolTipTimeOut_Specify_Global, True)
Return
Numpad3::
RunTollTipHotkeyInfo("`nTimeout Specify: "@ToolTipTimeOut_Specify_Global "ms" 					, @ToolTipTimeOut_Specify_Global)
Return
; =========================================================================================== [HOTKEY]
Numpad4::
RunTollTipDisplay("Display ToolTip `nTimeout Default: "@ToolTipTimeOut_Default_Global "ms"		, , False)
Return
Numpad5::
RunTollTipDisplay("Display ToolTip`nTimeout Specify: "@ToolTipTimeOut_Specify_Global "ms" 		, @ToolTipTimeOut_Specify_Global)
Return
Numpad6::
RunTollTipDisplay("Display ToolTip `nTimeout Default: "@ToolTipTimeOut_Default_Global "ms")
Return
; =========================================================================================== [HOTKEY]
~RControl::
SendInput, ^s
KeyWait, RControl
Run, %A_ScriptFullPath%
Return

; =========================================================================================== [HOTKEY] [EXIT APP]
#Include %A_ScriptDir%\\Script\ExitApp.ahk
