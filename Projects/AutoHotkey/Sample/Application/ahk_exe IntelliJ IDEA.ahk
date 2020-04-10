; =========================================================================================== [HOTKEY] [LINE COMMENT]
XButton2::
	If IsMouseOver_("ahk_exe idea64.exe")
	    SendInput, ^/
	KeyWait, XButton2
Return
; =========================================================================================== [HOTKEY] [BLOCK COMMENT]
~LControl & XButton2::
	If IsMouseOver_("ahk_exe idea64.exe")
	    SendInput, ^+/
	KeyWait, XButton2
Return
; =========================================================================================== [HOTKEY] [REFORMAT CODE + SAVE]
XButton1::
	If IsMouseOver_("ahk_exe idea64.exe") {
        SendInput, ^!{l} ; REFORMAT THE CODE
	    SendInput, ^s
    }
	KeyWait, XButton1
Return
; =========================================================================================== [HOTKEY]
~LShift & XButton2::
	If IsMouseOver_("ahk_exe idea64.exe")
	    SendInput, +{Home}
	KeyWait, XButton2
Return
; =========================================================================================== [HOTKEY]
~LShift & XButton1::
	If IsMouseOver_("ahk_exe idea64.exe")
	    SendInput, +{End}
	KeyWait, XButton1
Return
; =========================================================================================== [HOTKEY] [ALT + ENTER]
~LAlt & LButton::
	If IsMouseOver_("ahk_exe idea64.exe") {
        SendInput, {LButton}
	    SendInput, !{Enter}
    }
	KeyWait, LButton
Return
; =========================================================================================== [HOTKEY] [REFACTOR RENAME]
F2::
	If IsMouseOver_("ahk_exe idea64.exe") {
        SendInput, +{F6}
    }
	KeyWait, F2
Return
; =========================================================================================== [HOTSTRING] [SOP]
:C*:SOP:: 	; Typed in all-caps.
:C*:Sop:: 	; Typed with only the first letter upper-case.
; : :sop:: 	; Typed in any other combination.
:*:sop::
	SendInput, System.out.println();
	Sleep, 50
	SendInput, {LEFT 2}
Return
; =========================================================================================== [HOTSTRING] [SEP]
:C*:SEP:: 	; Typed in all-caps.
:C*:Sep:: 	; Typed with only the first letter upper-case.
; : :sep:: 	; Typed in any other combination.
:*:sep::
	SendInput, System.err.println();
	Sleep, 50
	SendInput, {LEFT 2}
Return
; =========================================================================================== [HOTSTRING] [TRY CATCH]
:C*:TRY:: 	; Typed in all-caps.
:C*:Try:: 	; Typed with only the first letter upper-case.
; : :sep:: 	; Typed in any other combination.
:*:try::
(
 try {

   }   catch (Exception e)     {

)
	Sleep, 100
        SendInput, ^!{l} ; REFORMAT THE CODE
	Sleep, 50
	SendInput, {UP 1}
Return
