; =========================================================================================== [OPTIONS]
#Include %A_ScriptDir%\\Script\Options.ahk
; =========================================================================================== [FUNCTION] [TOOLTIP]
#Include %A_ScriptDir%\\Script\ToolTip.ahk
@ToolTipTimeOut_Specify_Global = -5000  	; Re-Assign value for Specified TimeOut
@ToolTipTimeOut_Default_Global = -5000  	; Re-Assign value for Default TimeOut
; =========================================================================================== [FUNCTIONS]
#Include %A_ScriptDir%\\Script\Functions.ahk
; =========================================================================================== [FILES]
#Include %A_ScriptDir%\\Script\Files.ahk
SplitPath, file_mspaint, @mspaint_ext
; =========================================================================================== [VARIABLES]
#Include %A_ScriptDir%\\Script\Variables.ahk
; =========================================================================================== [PROCESS]
PID := DllCall("GetCurrentProcessId")		; Get the PID of this program when running.
; process_ := PID 							; This ahk produce PID once Running.
; process_ := "instanteyedropper.exe"
process_ = %@mspaint_ext%
Return
; =========================================================================================== [OPTIONS] [RETURN]
; Process, SubCommand [, PIDOrName, Value]

; SubCommand
; Exist [, PIDOrName]						; Checks whether the specified process is present.
; Close [, PIDOrName] 						; Forces the first matching process to close.
; List 										; Not yet implemented.
; Priority, PIDOrName, Level 				; Changes the priority level of the first matching process.
; Priority, PIDOrName, Level 				; Level should be one of the following letters or words: L (or Low), B (or BelowNormal), N (or Normal), A (or AboveNormal), H (or High), R (or Realtime).
; Priority, PIDOrName, Level 				; Note: Any process not designed to run at Realtime priority might reduce system stability If set to that level
; Wait, PIDOrName [, Timeout]				; Waits for the specified process to exist. Timeout the number of seconds.
; WaitClose, PIDOrName [, Timeout]			; Waits for all matching processes to close. Timeout the number of seconds.

; PID Or Name
; WinGet, OutputPID , PID [, WinTitle, WinText, ExcludeTitle, ExcludeText] 	; Another way to get the PID of specific window.
; PID := DllCall("GetCurrentProcessId").
; PID 										; The Process ID, which is a number that uniquely identifies one specific process (this number is valid only during the lifetime of that process).
; PID										; The PID of a newly launched process can be determined via the Run command. Similarly, the PID of a window can be determined with WinGet.
; PID 										; The Process command itself can also be used to discover a PID.
; Name 										; The name of a process is usually the same as its executable (without path), e.g. notepad.exe or winword.exe.
; Name 										; Since a name might match multiple running processes, only the first process will be operated upon. The name is not case sensitive.

; Level
; L (or Low)
; B (or BelowNormal)
; N (or Normal)
; H (or High)
; R (or Realtime)

; Value
; Timeout 									; Timeout the number of seconds.

; [ErrorLevel]
; [ErrorLevel] is set to 0 If a sub-command failed or timed out. Otherwise, it is set to a Process ID (PID).




; =========================================================================================== [HOTSTRING] [CHECK IF THE PROCESS IS EXIST]
:X*:00::
; Gosub, isprocess_exist
Return
:X*:11::
Process, Exist, %process_%
If ErrorLevel {  			; Process is [Present].
	Gosub, viewinformation_process
    MsgBox, The application is present.
}
Else 						; Process is [Absent].
	MsgBox, The application is ! present.
Return
; =========================================================================================== [HOTSTRING] [TERMINATE THE PROCESS]
:X*:22::
Process, Exist, %process_%
If ErrorLevel 				; Process is [Present].
{
	Process, Close, %process_%
	If ErrorLevel 			; Process is [Closed].
    	MsgBox, The application is close.
	Else 					; Process was failed to [Closed].
		MsgBox, The application is failed to close.
}
Return
:X*:212::
Loop, { 					; Close all programs = to %closeProcessName%
Process, Exist, %process_%
	If ErrorLevel { 		; ProcessName is [Present].
		Process, Close, %process_%
		If ErrorLevel 		; ProcessName is [Closed].
	    	Continue
		Else 				; ProcessName was failed to [Closed].
			Continue
	}Else 					; ProcessName is ! [Present].
		Break
}
Return
; =========================================================================================== [HOTSTRING] [SET THE PROGRAM PROCESS PRIORITY]
:X*:44::
Process, Priority, %process_%, L
Return
; =========================================================================================== [HOTSTRING] [WAIT FOR THE PROGRAM TO BE PRESENT WITHIN SPECIFY TIME]
:X*:55::
Process, Exist, %process_%
If ErrorLevel 				; Process is [Present].
{

} Else{ 					; Process is [Absent].
	Process, Wait, %process_%, 5
	If ErrorLevel 			; Process is [Present].
		MsgBox The process is up and running within 5 seconds.
	Else 					; Process is [Absent].
		MsgBox The process is not running within 5 seconds.
}
Return
; =========================================================================================== [HOTSTRING] [WAIT FOR THE PROGRAM TO BE CLOSE WITHIN SPECIFY TIME]
:X*:66::
Process, Exist, %process_%
If ErrorLevel 				; Process is [Present].
{
	Process, WaitClose, %process_%, 5
	If ErrorLevel 			; Process is [Closed/Terminated].
	    MsgBox The process did not close within 5 seconds.
	Else 					; Process is still [Running].
		MsgBox The process is close within 5 seconds.
}
Return

; =========================================================================================== [LABEL]
viewinformation_process:
	getvalWTPN := " ahk_exe " . process_

			getval_ID		:= GetWinGetCmd_(WinGet_ID , getvalWTPN)
			getval_Count	:= GetWinGetCmd_(WinGet_Count , getvalWTPN)

			wtitle 			:= GetWindowTitle_IDorIDLast(getval_ID)
			; Sleep, 100
			ActivateWindow_IDorIDLast(getval_ID)

Concat =
(
WinTitle: %wtitle%
ID: %getval_ID%
IDLast: %getval_IDLast%
)
RunTollTipDisplay(Concat)
Return
; =========================================================================================== [LABEL]
isprocess_exist:
PN = notepad.exe
PID := DllCall("GetCurrentProcessId")
getval := IsProcessExist_(PN) == 1 ? "True" : "False"
ConcatDisplay =
(
PIDorPN : %getval%
)
RunTollTipDisplay(ConcatDisplay)
Return




; =========================================================================================== [HOTKEY] [EXIT APP]
#Include %A_ScriptDir%\\Script\ExitApp.ahk
