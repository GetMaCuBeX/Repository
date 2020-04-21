; =========================================================================================== [HOTKEY]
XButton2::
	if IsMouseOver_("ahk_exe Code.exe")
		SendInput, ^/
    KeyWait, XButton2
Return
; =========================================================================================== [HOTKEY]
XButton1::
	if IsMouseOver_("ahk_exe Code.exe")
		SendInput, +!a
    KeyWait, XButton1
Return
; =========================================================================================== [HOTKEY]
~LControl & XButton2::
	if IsMouseOver_("ahk_exe Code.exe")
		SendInput, ^b
    KeyWait, XButton2
Return
; =========================================================================================== [HOTKEY]
~LControl & XButton1::
	if IsMouseOver_("ahk_exe Code.exe")
		SendInput, ^+{u}
    KeyWait, XButton1
	#KeyHistory, 0
	SetBatchLines, -1
	ListLines, Off
	SendMode Input ; Forces Send and SendRaw to use SendInput buffering for speed.
	SetTitleMatchMode, 3 ; A window's title must exactly match WinTitle to be a match.
	SetWorkingDir, %A_ScriptDir%
	SplitPath, A_ScriptName, , , , thisscriptname
	#MaxThreadsPerHotkey, 1 ; no re-entrant hotkey handling
	; DetectHiddenWindows, On
	; SetWinDelay, -1 ; Remove short delay done automatically after every windowing command except IfWinActive and IfWinExist
	; SetKeyDelay, -1, -1 ; Remove short delay done automatically after every keystroke sent by Send or ControlSend
	; SetMouseDelay, -1 ; Remove short delay done automatically after Click and MouseMove/Click/Drag

Return
; =========================================================================================== [HOTKEY]
F2::
	if IsMouseOver_("ahk_exe Code.exe")
		SendInput, ^h
    KeyWait, F2
Return
; =========================================================================================== [HOTKEY]
~LShift & XButton2::
	SendInput, +{Home}
	KeyWait, XButton2
Return
; =========================================================================================== [HOTKEY]
~LShift & XButton1::
	SendInput, +{End}
	KeyWait, XButton1
Return
