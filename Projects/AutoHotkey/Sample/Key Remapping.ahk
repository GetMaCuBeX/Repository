; =========================================================================================== [OPTIONS]
#Include %A_ScriptDir%\\Script\Options.ahk
; =========================================================================================== [FUNCTION] [TOOLTIP]
; #Include %A_ScriptDir%\\Script\ToolTip.ahk
; @ToolTipTimeOut_Specify_Global = -5000  ; Re-Assign value for Specified TimeOut
; @ToolTipTimeOut_Default_Global = -2000  ; Re-Assign value for Default TimeOut
; =========================================================================================== [FUNCTIONS]
#Include %A_ScriptDir%\\Script\Functions.ahk
; =========================================================================================== [VARIABLES]
; =========================================================================================== [FILES]
Return
; =========================================================================================== [OPTIONS] [RETURN]


; =========================================================================================== [HOTKEY] [EXIT APP]
#Include %A_ScriptDir%\\Script\ExitApp.ahk

; =========================================================================================== [HOTKEY] [ICON LOVER]
#IfWinActive ahk_exe icolover.exe
#Include %A_ScriptDir%\\Application\ahk_exe icolover.ahk
; =========================================================================================== [HOTKEY] [ART ICONS]
#IfWinActive ahk_exe ARTICONS.exe
#Include %A_ScriptDir%\\Application\ahk_exe ARTICONS.ahk
; =========================================================================================== [HOTKEY] [BOOTSTRAP STUDIO]
#IfWinActive ahk_exe Bootstrap Studio.exe
#Include %A_ScriptDir%\\Application\ahk_exe Bootstrap Studio.ahk
; =========================================================================================== [HOTKEY] [VISUAL STUDIO CODE]
#IfWinActive ahk_exe Code.exe
#Include %A_ScriptDir%\\Application\ahk_exe Code.ahk
; =========================================================================================== [HOTKEY] [COREL DRAW]
#IfWinActive ahk_exe CorelDRW.exe
#Include %A_ScriptDir%\\Application\ahk_exe CorelDRW.ahk
; =========================================================================================== [HOTKEY] [COREL DESIGNER TECHNICAL SUITE]
#IfWinActive ahk_exe Designer.exe
#Include %A_ScriptDir%\\Application\ahk_exe Designer.ahk
; =========================================================================================== [HOTKEY] [CONFIGURATION EDITOR EQUALIZER APO]
#IfWinActive ahk_exe Editor.exe
#Include %A_ScriptDir%\\Application\ahk_exe Equalizer APO.ahk
; =========================================================================================== [HOTKEY] [INTELLiJ IDEA]
#IfWinActive ahk_exe idea64.exe
#Include %A_ScriptDir%\\Application\ahk_exe IntelliJ IDEA.ahk
; =========================================================================================== [HOTKEY] [ADOBE ILLUSTRATOR]
#IfWinActive ahk_exe Illustrator.exe
#Include %A_ScriptDir%\\Application\ahk_exe Illustrator.ahk
; =========================================================================================== [HOTKEY] [JCREATOR PRO]
#IfWinActive ahk_exe JCreator.exe
#Include %A_ScriptDir%\\Application\ahk_exe JCreator.ahk
; =========================================================================================== [HOTKEY] [NETBEANS IDE]
#IfWinActive ahk_exe navicat.exe
#Include %A_ScriptDir%\\Application\ahk_exe navicat.ahk
; =========================================================================================== [HOTKEY] [NETBEANS IDE]
#IfWinActive ahk_exe netbeans64.exe
#Include %A_ScriptDir%\\Application\ahk_exe netbeans64.ahk
; =========================================================================================== [HOTKEY] [NOTEPAD++]
#IfWinActive ahk_exe notepad++.exe
#Include %A_ScriptDir%\\Application\ahk_exe notepad++.ahk
; =========================================================================================== [HOTKEY] [ADOBE PHOTOSHOP]
#IfWinActive ahk_exe Photoshop.exe
#Include %A_ScriptDir%\\Application\ahk_exe Photoshop.ahk
; =========================================================================================== [HOTKEY] [SUBLIME TEXT]
#IfWinActive ahk_exe sublime_text.exe
#Include %A_ScriptDir%\\Application\ahk_exe sublime_text.ahk
; =========================================================================================== [HOTKEY] [ULTRA EDIT STUDIO]
#IfWinActive ahk_exe UEStudio.exe
#Include %A_ScriptDir%\\Application\ahk_exe UEStudio.ahk
; =========================================================================================== [HOTKEY] [XYPLORER]
#IfWinActive ahk_exe XYplorer.exe
#Include %A_ScriptDir%\\Application\ahk_exe XYplorer.ahk


