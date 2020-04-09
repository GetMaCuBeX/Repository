
; [MC - Mouse Cursor]
; [OPTVR - Output Variable]
; [SUBCMD - Sub Command]
; [PID - Process ID]
; [PN - Process Name]
; [WAT - Window Active Title]
; [W_ID - Window ID]
; [WT - Window Title]
; =========================================================================================== [FUNCTION]
IsMouseOver_(WT){
MouseGetPos,,, W_ID
return WinExist(WT . " ahk_id " . W_ID)
}
; =========================================================================================== [FUNCTION]
IsProcessExist_(PIDorPN){
Process, Exist, %PIDorPN%
If ErrorLevel 			; Process is [Present].
	Return True
Else
	Return False
}
; =========================================================================================== [FUNCTION]
GetWinGetCmd_(SUBCMD , WT){
WinGet, OPTVR , %SUBCMD%, %WT% 								; Get the subcommand of WT.
Return %OPTVR% 												; Return window/process SUBCMD.
}

; =========================================================================================== [FUNCTION]
GetWindowTitle_ProcessName(PN){
	WT_PN	:= " ahk_exe " . PN
	If (WinExist(WT_PN)){
		WinGetTitle, WT, %WT_PN%
		Return %WT%
	}
Return
}
; =========================================================================================== [FUNCTION]
GetWindowTitle_IDorIDLast(IDorIDLast){
	WT_IDorIDLAST	:= " ahk_id " . IDorIDLast
	If (WinExist(WT_IDorIDLAST)){
		WinGetTitle, WT, %WT_IDorIDLAST%
		Return %WT%
	}
Return
}
; =========================================================================================== [FUNCTION]
GetWindowID_MC(){
MouseGetPos, , , W_ID
Return %W_ID%
}
; =========================================================================================== [FUNCTION]
GetWindowTitle_MC(){
W_ID := GetWindowID_MC()
	if (W_ID != ""){
		WT_W_ID := " ahk_id " . W_ID
		WinGetTitle, WT, %WT_W_ID%							; Get the Window Title via ID.

		if(WT != "")
			Return %WT%
		Else
			Return False
	}Else
		Return False
}
; =========================================================================================== [FUNCTION]
ActivateWindow_MC(){
MouseGetPos, , , W_ID
WinActivate, ahk_id %W_ID%
Sleep, 100
}
; =========================================================================================== [FUNCTION]
ActivateWindow_IDorIDLast(IDorIDLast){
WT_IDorIDLAST	:= " ahk_id " . IDorIDLast
If (WinExist(WT_IDorIDLAST))
		WinActivate,  ahk_id %IDorIDLast%
Sleep, 100
}
; =========================================================================================== [FUNCTION]
ProcessClose_PN(PN){
	Loop, {													; CLOSE ALL PROGRAMS = TO %PN%
		Process, Exist, %PN%
		If ErrorLevel { 			; PN is [Present].
			Process, Close, %PN%
			If ErrorLevel { 		; PN is [Closed].
			   	Continue
			} Else { 				; PN was Failed to [Closed].
				Continue
			}
		} Else {					; PN is ! [Present].
			Break
		}
	}
}
ProcessClose_PID(PID){  									; Close program/process = to %PID%
Process, Exist, %PID%
	If ErrorLevel {					; PID is [Present].
		Process, Close, %PID%
		If ErrorLevel {				; PID is [Closed].
		} Else {					; PID was [Failed] to [Closed].
			MsgBox, %PID% FAILED TO CLOSE
		}
	} else{
		MsgBox, %PID% NOT PRESENT
	}
}
IsProcessNameFound_List(PN){
	Switch PN
	{
		Case "explorer.exe", "sublime_text.exe", "Code.exe":
			Return True
		Default:
		    Return False
	}
}
; =========================================================================================== [FUNCTION]
MsgBox(Text, Titles := "", TimeOut := ""){
MsgBox, 64, %Titles%, %Text%,  %TimeOut%
}
