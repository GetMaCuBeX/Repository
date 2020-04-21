; =========================================================================================== [HOTKEY] [FORMAT CODE]
XButton2::
	If IsMouseOver_("ahk_exe netbeans64.exe")
		function_netbeans_code_comment()
	KeyWait, XButton2
Return
; =========================================================================================== [HOTKEY] [COMMENT]
XButton1::
	If IsMouseOver_("ahk_exe netbeans64.exe")
		function_netbeans_code_Format()
	SendInput, ^s
	KeyWait, XButton1
Return
; =========================================================================================== [HOTKEY]
~LShift & XButton2::
	If IsMouseOver_("ahk_exe netbeans64.exe")
		SendInput, +{Home}
	KeyWait, XButton2
Return
; =========================================================================================== [HOTKEY]
~LShift & XButton1::
	If IsMouseOver_("ahk_exe netbeans64.exe")
		SendInput, +{End}
	KeyWait, XButton1
Return
; =========================================================================================== [HOTKEY] [REFACTOR RENAME]
F2::
	If IsMouseOver_("ahk_exe netbeans64.exe") {
        SendInput, ^{r}
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
; : :Try:: 	; Typed in any other combination.
:*:try::
(
 try {

   }   catch (Exception e)     {

)
	Sleep, 100
	SendInput, !+{f}
	Sleep, 50
	SendInput, {UP 1}
Return
; =========================================================================================== [HOTSTRING] [BLOCK COMMENT]
 :*:/**/::
	SendInput, /**/
	Sleep, 100
	SendInput, {Left 2}
	Sleep, 50
	SendInput, !+{f}
	Sleep, 50
Return
; =========================================================================================== [HOTKEY] [BLOCK COMMENT]
LControl & XButton2::
	SendInput, /**/
	Sleep, 100
	SendInput, {Left 2}
	Sleep, 50
	KeyWait, XButton2
	SendInput, !+{f}
	Sleep, 50
Return
; =========================================================================================== [HOTKEY] [UNDO]
; LControl & XButton1::
; 	SendInput, ^{z}
; 	KeyWait, XButton1
; Return
; =========================================================================================== [HOTKEY] [SHOW HINTS]
AppsKey::
	function_netbeans_code_show_hints()
	KeyWait, AppsKey
Return
; =========================================================================================== [FUNCTION]
function_netbeans_code_Format() {
	SendInput, +!{f}
}
; =========================================================================================== [FUNCTION]
function_netbeans_file_run() {
	SendInput, +{F6}
}
; =========================================================================================== [FUNCTION]
function_netbeans_code_comment(){
	SendInput, ^/
	; SendInput, ^+c ; Alternative
}
; =========================================================================================== [FUNCTION]
function_netbeans_code_show_hints(){
	SendInput, !{Enter}
}

