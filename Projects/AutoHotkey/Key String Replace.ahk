; =========================================================================================== [OPTIONS]
#Include %A_ScriptDir%\\Script\Options.ahk
; =========================================================================================== [FUNCTION] [TOOLTIP]
#Include %A_ScriptDir%\\Script\ToolTip.ahk
@ToolTipTimeOut_Specify_Global = -4000  	; Re-Assign value for Specified TimeOut
; @ToolTipTimeOut_Default_Global = -2000  	; Re-Assign value for Default TimeOut
; =========================================================================================== [FILES]
#Include %A_ScriptDir%\\Script\Files.ahk
; SplitPath, file_ccleaner64, 	@ccleaner64_with_ext
; SplitPath, file_mspaint, 		@mspaint_with_ext
; SplitPath, file_notepad, 		@notepad_with_ext
; =========================================================================================== [VARIABLES]
; =========================================================================================== [VARIABLES]
StringCaseSense, On 			; String comparisons are case sensitive.
; StringCaseSense, Off 			; The letters A-Z are considered identical to their lowercase counterparts.
; StringCaseSense, Locale 		; String comparisons are case insensitive according to the rules of the current user's locale.
Global SearchText := 	" "
Global ReplaceText := 	"_"

Return
; =========================================================================================== [OPTIONS] [RETURN]

; =========================================================================================== [HOTSTRING]
:X*:11::
OldStr := "The Quick brown. Fox jump over the lazy dog."
NewStr := StrReplace(OldStr, SearchText, ReplaceText)
MsgBox, %NewStr%
Return
; =========================================================================================== [HOTSTRING]
:X*:22::
MyString = The Quick brown. Fox jump over the lazy dog.
Loop
{
    MyString := StrReplace(MyString, SearchText, ReplaceText, Count)
    if (Count = 0)  ; No more replacements needed.
        break
}
MsgBox, %MyString%
Return
; =========================================================================================== [HOTSTRING]
:X*:33::
MyString := Clipboard
Loop
{
    MyString := StrReplace(MyString, SearchText, ReplaceText, Count)
    if (Count = 0)  ; No more replacements needed.
        break
}
MsgBox, %MyString%
Return
; =========================================================================================== [HOTSTRING]
:X*:44::
NewStr := StrReplace(Clipboard, SearchText, ReplaceText)
IfWinExist, Untitled - Notepad
	WinActivate
Else
	Run, C:\Windows\System32\notepad.exe
WinWait, Untitled - Notepad
WinActivate
SendRaw, %NewStr%
WinWait, Untitled - Notepad
Return
; =========================================================================================== [HOTSTRING]
; =========================================================================================== [FUNCTION]
get_winget_subcommand_on_active_window(subcommand){
WinGetActiveTitle, PresentActiveWindow 								; GET PRESENT ACTIVE WINDOW TITLE
WinGet, output , %subcommand%, %PresentActiveWindow% 				; GET THE SUBCOMMAND OF ACTIVE WINDOW TITLE
Return %output% 													; RETURN subcommand VALUE
}

:X*:55::
; NewStr := StrReplace(Clipboard, SearchText, ReplaceText)
NewStr := Clipboard

Run, %file_notepad%
WinWait, Untitled - Notepad

WinGet, OutputID, IDLast , Untitled - Notepad
WinActivate, ahk_id %OutputID%
Sleep, 100

process_PID := get_winget_subcommand_on_active_window("PID")
Process, Wait, %process_PID%, 5
If ErrorLevel 		; Process is [PRESENT] Or Found within 5sec.
{					; Execute the code if [FOUND]
	WinActivate, ahk_id %process_PID%
	Sleep, 100
	ConcatDisplay = Notepad`nPID: %process_PID%
	RunTollTipDisplay(ConcatDisplay, @ToolTipTimeOut_Specify_Global)
	SendRaw, %NewStr%
}
Return

; =========================================================================================== [HOTKEY]
~RControl::
SendInput, ^s
KeyWait, RControl
Run, %A_ScriptFullPath%
Return


; =========================================================================================== [HOTKEY] [EXIT APP]
#Include %A_ScriptDir%\\Script\ExitApp.ahk
