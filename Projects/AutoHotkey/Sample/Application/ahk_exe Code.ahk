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
