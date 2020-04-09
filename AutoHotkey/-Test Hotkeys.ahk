; =========================================================================================== [OPTIONS]
#Include %A_ScriptDir%\\Script\Options.ahk
; =========================================================================================== [FUNCTION] [TOOLTIP]
#Include %A_ScriptDir%\\Script\ToolTip.ahk
@ToolTipTimeOut_Specify_Global = -5000  ; Re-Assign value for Specified TimeOut
@ToolTipTimeOut_Default_Global = -2000  ; Re-Assign value for Default TimeOut
; =========================================================================================== [FUNCTIONS]
#Include %A_ScriptDir%\\Script\Functions.ahk
; =========================================================================================== [VARIABLES]
; =========================================================================================== [FILES]
Return
; =========================================================================================== [OPTIONS] [RETURN]



:*:11::
FormatTime, OutputVar, , h:mm:ss tt
MsgBox, %OutputVar%
Return



; =========================================================================================== [HOTKEY] [EXIT APP]
#Include %A_ScriptDir%\\Script\ExitApp.ahk
