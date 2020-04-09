; =========================================================================================== [OPTIONS]
#Include %A_ScriptDir%\\Script\Options.ahk
; =========================================================================================== [FUNCTION] [TOOLTIP]
#Include %A_ScriptDir%\\Script\ToolTip.ahk
@ToolTipTimeOut_Specify_Global = -5000  	; Re-Assign value for Specified TimeOut
@ToolTipTimeOut_Default_Global = -10000  	; Re-Assign value for Default TimeOut
; =========================================================================================== [FUNCTIONS]
#Include %A_ScriptDir%\\Script\Functions.ahk
; =========================================================================================== [FILES]
#Include %A_ScriptDir%\\Script\Files.ahk
; SplitPath, file_ccleaner64, 	@ccleaner64_ext
; SplitPath, file_mspaint, 		@mspaint_ext
; SplitPath, file_notepad, 		@notepad_ext
; =========================================================================================== [VARIABLES]
#Include %A_ScriptDir%\\Script\Variables.ahk
; =========================================================================================== [PROCESS]
Return
; =========================================================================================== [OPTIONS] [RETURN]

; WinGet, OutputVar [, SubCommand, WinTitle, WinText, ExcludeTitle, ExcludeText]
; [Sub-commands]
; ID 										; Retrieves the unique ID number of a window. [Same Application Running = Unique ID]
; IDLast 									; Retrieves the unique ID number of the last/bottommost window if there is more than one match. [Same Application Running = Unique ID]
; PID 										; Retrieves the Process ID number of a window. [Multiple Program Running/Same Application = Unique PID] [Process]
; ProcessName 								; Retrieves the name of the process that owns a window. [Multiple Program Running/Same Application = Same ProcessName] [Process]
; ProcessPath 			 					; Retrieves the full path and name of the process that owns a window.
; Count 									; Retrieves the number of existing windows that match the title/text parameters.
; List 										; Retrieves the unique ID numbers of all existing windows that match the title/text parameters.
; MinMax 									; Retrieves the minimized/maximized state for a window.
; ControlList 								; Retrieves the control name for each control in a window.
; ControlListHwnd  							; Retrieves the unique ID number for each control in a window.
; Transparent 								; Retrieves the degree of transparency of a window.
; TransColor 								; Retrieves the color that is marked transparent in a window.
; Style 									; Retrieves an 8-digit hexadecimal number representing the style of a window.
; ExStyle 									; Retrieves an 8-digit hexadecimal number representing the extended style of a window.

/*
wgetID				:=GetWinGetCmd_(WinGet_ID , wintitle_W_ID)
wgetIDLast			:=GetWinGetCmd_(WinGet_IDLast , wintitle_W_ID)
wgetPID				:=GetWinGetCmd_(WinGet_PID , wintitle_W_ID)
wgetProcessName		:=GetWinGetCmd_(WinGet_ProcessName , wintitle_W_ID)
wgetProcessPath		:=GetWinGetCmd_(WinGet_ProcessPath , wintitle_W_ID)
wgetCount			:=GetWinGetCmd_(WinGet_Count , wintitle_W_ID)
wgetList			:=GetWinGetCmd_(WinGet_List , wintitle_W_ID)
wgetMinMax			:=GetWinGetCmd_(WinGet_MinMax , wintitle_W_ID)
wgetControlList		:=GetWinGetCmd_(WinGet_ControlList , wintitle_W_ID)
wgetControlListHwnd	:=GetWinGetCmd_(WinGet_ControlListHwnd , wintitle_W_ID)
wgetTransparent		:=GetWinGetCmd_(WinGet_Transparent , wintitle_W_ID)
wgetTransColor		:=GetWinGetCmd_(WinGet_TransColor , wintitle_W_ID)
wgetStyle			:=GetWinGetCmd_(WinGet_Style , wintitle_W_ID)
wgetExStyle			:=GetWinGetCmd_(WinGet_ExStyle , wintitle_W_ID)
file_notepad
getval_WinTitle 	:= GetWindowTitle_IDorIDLast(wgetID or wgetIDLast)
*/


; =========================================================================================== [HOTSTRING]
:X*:22::
ClipSaved:=Clipboard
isNoError := paste_clipboard_to_notepad(file_notepad, file_notepad_WT)
; isNoError := paste_clipboard_to_notepad(file_notepad, "Untitled - Notepad")
Sleep, 200
If (isNoError==True)
	SendRaw, %ClipSaved%
Else
	RunTollTipDisplay(isNoError)
Return

; =========================================================================================== [FUNCTION]
paste_clipboard_to_notepad(FILE , FILE_WT) {
	If (FileExist(FILE)) {
		Run, %FILE%
		WinWaitActive, %FILE_WT% ; Use [Sleep] After Using [WinWaitActive]
		Sleep, 200
		; GV_ID			:= GetWinGetCmd_(WinGet_ID , FILE_WT)
		; GV_IDLast		:= GetWinGetCmd_(WinGet_IDLast , FILE_WT)
		; GV_Count		:= GetWinGetCmd_(WinGet_Count , FILE_WT)
		; Switch getval_Count
		; {
		; 	Case 1:
		; 		GV_W_ID	:= " ahk_id " . GV_ID
		; 		WinActivate, GV_W_ID
		; 		; wgetID			:= GetWinGetCmd_(WinGet_ID , wintitle_ID)
		; 		; ActivateWindow_IDorIDLast(getval_ID)
		; 		RunTollTipDisplay("Win Title: " . FILE_WT . "`nCount: " . GV_Count)
		; 		Return True
		; 	Default:
		; 		GV_W_ID	:= " ahk_id " . getval_IDLast
		; 		WinActivate, GV_IDLast
		; 		; wgetIDLast		:= GetWinGetCmd_(WinGet_IDLast, wintitle_ID)
		; 		; ActivateWindow_IDorIDLast(GV_IDLast)
		; 		RunTollTipDisplay("Win Title: " . FILE_WT . "`nCount: " . GV_Count)
		; 		Return True
		; }
		Return True
	} Else{
		returnval := "File ! Exist. `nName: " . FILE
		Return %returnval%
	}
}
; =========================================================================================== [HOTKEY]
`::
; Gosub, windowinformation_activewindow
; Gosub, windowinformation_mousecursor
; Gosub, windowtitle_mousecursor
; Gosub, windowinformation_windowtitle ; Notepad Opened
Return
; =========================================================================================== [HOTKEY]
~Shift & Delete::
~Delete::
Gosub, processclose_mousecursor
KeyWait, Delete
Return
; =========================================================================================== [LABEL]
processclose_mousecursor:
getval_W_ID_MC := GetWindowID_MC()
If (getval_W_ID_MC != "") {
	wintitle_W_ID := " ahk_id " . getval_W_ID_MC

	wgetProcessName		:= GetWinGetCmd_(WinGet_ProcessName , wintitle_W_ID)
	wgetPID				:= GetWinGetCmd_(WinGet_PID , wintitle_W_ID)
	wgetID				:= GetWinGetCmd_(WinGet_ID , wintitle_W_ID)
 	getval_WinTitle 	:= GetWindowTitle_IDorIDLast(wgetID)


	If not (IsProcessNameFound_List(wgetProcessName)) {
		If (wgetProcessName != "") {
			If GetKeyState("Shift")
				ProcessClose_PN(wgetProcessName)	; Close all process with = to PN
			ProcessClose_PID(wgetPID)				; Close only process with = to PID
		}
	}
}
Return

; =========================================================================================== [LABEL]
windowtitle_mousecursor:
windowtitle := GetWindowTitle_MC()
if (windowtitle != False) {
	RunTollTipDisplay(windowtitle)
	; ActivateWindow_MC()
}
Return

; =========================================================================================== [LABEL]
windowinformation_activewindow:
WinGetActiveTitle, WindowTitle_Active
wgetProcessName := GetWinGetCmd_(WinGet_ProcessName, WindowTitle_Active)
if (wgetProcessName!="") {

	wgetPID				:= GetWinGetCmd_(WinGet_PID , WindowTitle_Active)
	wgetProcessPath		:= GetWinGetCmd_(WinGet_ProcessPath , WindowTitle_Active)
	wgetID				:= GetWinGetCmd_(WinGet_ID , WindowTitle_Active)
 	getval_WinTitle 	:= GetWindowTitle_IDorIDLast(wgetID)

	ConcatDisplay =
(
Window Title : %WindowTitle_Active%
%WinGet_ProcessName% : %wgetProcessName%
%WinGet_PID% : %wgetPID%
%WinGet_ProcessPath% : %wgetProcessPath%
)
	RunTollTipDisplay(ConcatDisplay)
}
Return
; =========================================================================================== [LABEL]
windowinformation_mousecursor:
getval_W_ID_MC := GetWindowID_MC()
if (getval_W_ID_MC != "") {
	wintitle := " ahk_id " . getval_W_ID_MC
	; WinGetTitle, WindowTitle_ahk_id, %wintitle%

	wgetID				:= GetWinGetCmd_(WinGet_ID , wintitle)
	wgetProcessName		:= GetWinGetCmd_(WinGet_ProcessName , wintitle)
	wgetPID				:= GetWinGetCmd_(WinGet_PID , wintitle)
	wgetProcessPath		:= GetWinGetCmd_(WinGet_ProcessPath , wintitle)

 	getval_WinTitle 	:= GetWindowTitle_IDorIDLast(wgetID)
	; ActivateWindow_IDorIDLast(wgetID)

	ConcatDisplay =
	(
Window Title : %getval_WinTitle%
%WinGet_ProcessName% : %wgetProcessName%
%WinGet_PID% : %wgetPID%
%WinGet_ProcessPath% : %wgetProcessPath%
	)
	RunTollTipDisplay(ConcatDisplay)
}
Return
; =========================================================================================== [LABEL]
windowinformation_windowtitle:
wintitle := "Untitled - Notepad"
If WinExist(wintitle) {
	getval_ID			:= GetWinGetCmd_(WinGet_ID , wintitle)
	getval_IDLast		:= GetWinGetCmd_(WinGet_IDLast , wintitle)
	getval_Count		:= GetWinGetCmd_(WinGet_Count , wintitle)
	IF (getval_Count == 1) { 			; Proceed if only Single instance/process is running.
		wintitle_ID 	:= "ahk_id" . getval_ID
		WinGetText, OutputVar1 , %wintitle_ID%
		WinActivate, %wintitle_ID%

		wgetProcessName	:= GetWinGetCmd_(WinGet_ProcessName , wintitle_ID)
		wgetPID			:= GetWinGetCmd_(WinGet_PID , wintitle_ID)
		wgetProcessPath	:= GetWinGetCmd_(WinGet_ProcessPath , wintitle_ID)
		wgetID			:= GetWinGetCmd_(WinGet_ID , wintitle_ID)

 		getval_WinTitle := GetWindowTitle_IDorIDLast(wgetID)

		ConcatDisplay1 =
(
%WinGet_ProcessName% : %wgetProcessName%
%WinGet_ID% : %wgetID%
%WinGet_PID% : %wgetPID%
%WinGet_ProcessPath% : %wgetProcessPath%
Count: %getval_Count%
Text ID :
%OutputVar1%
)
		RunTollTipDisplay(ConcatDisplay1)
	} Else {
		wintitle_IDLast := " ahk_id " . getval_IDLast
		WinGetText, OutputVar2 , %wintitle_IDLast%
		WinActivate, %wintitle_IDLast%

		wgetProcessName	:= GetWinGetCmd_(WinGet_ProcessName , wintitle_IDLast)
		wgetPID			:= GetWinGetCmd_(WinGet_PID , wintitle_IDLast)
		wgetProcessPath	:= GetWinGetCmd_(WinGet_ProcessPath , wintitle_IDLast)
		wgetID			:= GetWinGetCmd_(WinGet_ID , wintitle_IDLast)

 		getval_WinTitle := GetWindowTitle_IDorIDLast(getval_IDLast)


		ConcatDisplay2 =
(
%WinGet_ProcessName% : %wgetProcessName%
%WinGet_ID% : %wgetID%
%WinGet_PID% : %wgetPID%
%WinGet_ProcessPath% : %wgetProcessPath%
Count: %getval_Count%
Text IDLast : %getval_IDLast%
%OutputVar2%
)
		RunTollTipDisplay(ConcatDisplay2)
	}
}
Return

; =========================================================================================== [HOTKEY] [REMOVE TOOLTIP WHEN MOUSE CLICK]
~RButton::
ToolTip
Return
~LButton::
ToolTip
Return


; =========================================================================================== [HOTKEY] [EXIT APP]
#Include %A_ScriptDir%\\Script\ExitApp.ahk
