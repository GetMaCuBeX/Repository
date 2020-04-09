; =========================================================================================== [OPTIONS]
#Include %A_ScriptDir%\\Script\Options.ahk
; =========================================================================================== [FUNCTION] [TOOLTIP]
#Include %A_ScriptDir%\\Script\ToolTip.ahk
; @ToolTipTimeOut_Specify_Global = -5000  ; Re-Assign value for Specified TimeOut
; @ToolTipTimeOut_Default_Global = -2000  ; Re-Assign value for Default TimeOut
; =========================================================================================== [FUNCTIONS]
#Include %A_ScriptDir%\\Script\Functions.ahk
; =========================================================================================== [FILES]
#Include %A_ScriptDir%\\Script\Files.ahk
; SplitPath, file_ccleaner64, 	@ccleaner64_ext
; SplitPath, file_mspaint, 		@mspaint_ext
; SplitPath, file_notepad, 		@notepad_ext
; =========================================================================================== [VARIABLES]
Return


; =========================================================================================== [HOTKEY] [NETBEANS IDE]
#IfWinActive ahk_exe netbeans64.exe
; =========================================================================================== [HOTSTRING] [SOP]
:C:FXML:: 	; Typed in all-caps.
	SendInput, FXMLLoader.load(getClass().getResource(""));
	Sleep, 50
	SendInput, !+{f}
	Sleep, 50
	SendInput, {LEFT 4}
	Sleep, 50
Return

; =========================================================================================== [HOTSTRING] [SOP]
; :~*:.:: 	; Typed in all-caps.
; 	Sleep, 100
; 	SendInput, ^{space}
; 	Sleep, 50
; Return


; =========================================================================================== [HOTKEY] [EXIT APP]
#Include %A_ScriptDir%\\Script\ExitApp.ahk

