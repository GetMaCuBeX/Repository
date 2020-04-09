; =========================================================================================== [HOTKEY] [COMMENT]
XButton2::
	If IsMouseOver_("ahk_exe sublime_text.exe")
		SendInput, ^/
	KeyWait, XButton2
Return
; =========================================================================================== [HOTKEY] [BLOCK COMMENT]
XButton1::
	If IsMouseOver_("ahk_exe sublime_text.exe")
		SendInput, ^+/
	KeyWait, XButton1
Return
; =========================================================================================== [HOTKEY] [BUILD]
~MButton::
	If IsMouseOver_("ahk_exe sublime_text.exe")
		SendInput, ^b
	KeyWait, MButton
Return
; =========================================================================================== [HOTKEY]
F2:: ; REPLACE
	If IsMouseOver_("ahk_exe sublime_text.exe")
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
; =========================================================================================== [HOTKEY]
~LControl & XButton2:: ; SHOW/HIDE SIDEBAR
	SendInput, ^k
	SendInput, ^b
	KeyWait, XButton2
Return

