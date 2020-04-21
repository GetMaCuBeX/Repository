; =========================================================================================== [HOTKEY]
~XButton1::
	If IsMouseOver_("ahk_exe navicat.exe"){
		KeyWait, XButton1
		SendInput, {F5}
	}
Return
