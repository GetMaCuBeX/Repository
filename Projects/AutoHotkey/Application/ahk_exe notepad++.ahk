; =========================================================================================== [HOTKEY]
XButton2::
	SendInput, ^q
	KeyWait, XButton2
Return
; =========================================================================================== [HOTKEY]
XButton1::
	SendInput, ^+q
	KeyWait, XButton1
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
