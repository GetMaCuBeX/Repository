; =========================================================================================== [OPTIONS]
#Include %A_ScriptDir%\\Script\Options.ahk
; =========================================================================================== [FUNCTION] [TOOLTIP]
#Include %A_ScriptDir%\\Script\ToolTip.ahk
; @ToolTipTimeOut_Specify_Global = -5000  ; Re-Assign value for Specified TimeOut
; @ToolTipTimeOut_Default_Global = -2000  ; Re-Assign value for Default TimeOut
; =========================================================================================== [VARIABLES] [MENU ITEM]
label3_previous_selected = null
label3_lock_previous_selected = null
; =========================================================================================== [VARIABLES] [ICON]
IconFolderName = %A_ScriptDir%\Icons\
IconUnlock = %IconFolderName%Unlock.ico
IconLock = %IconFolderName%Lock.ico
; =========================================================================================== [MENU ITEM] [ADD]
Menu,	MI1,		add,	List 1,						label1
Menu,	MI1,		add,	List 2,						label1
Menu,	MI1,		add,	List 3,						label1
; =========================================================================================== [MENU ITEM] [ADD]
Menu,	MI2,		add,	Sub CBox 1,					label2
Menu,	MI2,		add,	Sub CBox 2,					label2
Menu,	MI2,		add,	Sub CBox 3,					label2
; =========================================================================================== [MENU ITEM] [ADD]
Menu,	MI3,		add,	Lock,						label3_lock
Menu,	MI3,		Add 								; Separator
Menu,	MI3,		add,	Sub Group-A CBox 1,			label3
Menu,	MI3,		add,	Sub Group-A CBox 2,			label3
Menu,	MI3,		add,	Sub Group-A CBox 3,			label3
Menu,	MI3,		Add
Menu,	MI3,		add,	Sub Group-B CBox 1,			label4
Menu,	MI3,		add,	Sub Group-B CBox 2,			label4
Menu,	MI3,		add,	Sub Group-B CBox 3,			label4
; =========================================================================================== [MENU ITEM] [ADD]
Menu,	MI4,		add,	Select Me,					label1
; =========================================================================================== [MENU] [ADD]
Menu,	MN1,		Add,	Selection List,				:MI1			; 1.0
Menu,	MN1,		Add 								; Separator
Menu,	MN1,		Add,	CheckBox UnGrouped,			:MI2			; 2.0
Menu,	MN1,		Add,	CheckBox Grouped,			:MI3			; 3.0
Menu,	MN1,		Add 								; Separator
Menu, 	MN1.4.2,	add,	Level 2,					:MI4			; 4.2
Menu, 	MN1.4.1,	add,	Level 1,					:MN1.4.2		; 4.1
Menu,	MN1,		Add,	Other Menu List,			:MN1.4.1		; 4.0
Menu,	MN1,		Add 								; Separator
Menu,	MN1,		Add,	Exit,						ExitHotkey		; 5.0
; =========================================================================================== [MENU] [ICON]
Menu,	MN1,		Icon,	Selection List,				%IconFolderName%2.ico
Menu,	MN1,		Icon,	CheckBox UnGrouped,			%IconFolderName%3.ico
Menu,	MN1,		Icon,	CheckBox Grouped,			%IconFolderName%4.ico
Menu, 	MN1, 		Icon, 	Exit, 						%IconFolderName%1.ico
; =========================================================================================== [MENU ITEM] [ICON]
Menu,	MI3,		Icon,	Lock,						%IconLock%
Menu,	MI3,		Icon,	Sub Group-A CBox 1,			%IconFolderName%10.ico
Menu,	MI3,		Icon,	Sub Group-A CBox 2,			%IconFolderName%12.ico
Menu,	MI3,		Icon,	Sub Group-A CBox 3,			%IconFolderName%11.ico
Return
; =========================================================================================== [OPTIONS] [RETURN]

; =========================================================================================== [LABEL]
label1:
TipInfo =
(
Menu:%A_ThisMenu%
Item:%A_ThisMenuItem%
)
RunTollTipDisplay(TipInfo, @ToolTipTimeOut_Specify_Global)
Return
; =========================================================================================== [LABEL]
label2:
Menu, 	MI2, ToggleCheck, %A_ThisMenuItem%
Return
; =========================================================================================== [LABEL]
label3_lock:
label3_lock_present_selected = %A_ThisMenuItem%
If ("Lock" == label3_lock_present_selected){ ; IF MENU NAME IS LOCK
Menu,	%A_ThisMenu%,	Icon,			%A_ThisMenuItem%,	%IconUnlock%
Menu, 	%A_ThisMenu%, 	Rename, 		%A_ThisMenuItem%, 	Unlock
label3_Command("Disable")
label4_Command("Disable")
}
Else { ; IF MENU NAME IS UNLOCK
Menu,	%A_ThisMenu%,	Icon,			%A_ThisMenuItem%,	%IconLock%
Menu, 	%A_ThisMenu%, 	Rename, 		%A_ThisMenuItem%, 	Lock
label3_Command("Enable")
label4_Command("Enable")
}
Return
; =========================================================================================== [LABEL]
label3:
Gosub, label3_selected_item
Return
; =========================================================================================== [LABEL]
label3_selected_item:
label3_present_selected = %A_ThisMenuItem%
if not(label3_previous_selected == label3_present_selected){
label3_Command("UnCheck")
Gosub, ThisMenuItem_Check
label3_previous_selected = %A_ThisMenuItem%
} else{	; IF SAME MENU SELECTED
Gosub, ThisMenuItem_ToggleCheck
label3_previous_selected = null
}
Return
; =========================================================================================== [LABEL]
label4:
label4_Command("UnCheck")
Gosub, ThisMenuItem_Check
Return
label5:
; =========================================================================================== [LABEL]
Return
; =========================================================================================== [FUNCTION]
label3_Command(Command){
Menu,	MI3,	%Command%,	Sub Group-A CBox 1
Menu,	MI3,	%Command%,	Sub Group-A CBox 2
Menu,	MI3,	%Command%,	Sub Group-A CBox 3
}
; =========================================================================================== [FUNTION]
label4_Command(Command){
Menu,	MI3,	%Command%,	Sub Group-B CBox 1
Menu,	MI3,	%Command%,	Sub Group-B CBox 2
Menu,	MI3,	%Command%,	Sub Group-B CBox 3
}
; =========================================================================================== [LABEL]
ThisMenuItem_Check:
Menu,	%A_ThisMenu%,	Check,			%A_ThisMenuItem%
Return
; =========================================================================================== [LABEL]
ThisMenuItem_ToggleCheck:
Menu,	%A_ThisMenu%,	ToggleCheck,	%A_ThisMenuItem%
Return
ThisMenuItem_UnCheck:
Menu,	%A_ThisMenu%,	UnCheck,		%A_ThisMenuItem%
Return
; =========================================================================================== [LABEL]
ExitHotkey:
ExitApp
Return
; =========================================================================================== [HOTKEY] [DISPLAY CONTEXT MENU]
~Alt::
Menu, MN1, Show
; Menu, MN1.4.1, Show
Return

; =========================================================================================== [HOTKEY] [EXIT APP]
#Include %A_ScriptDir%\\Script\ExitApp.ahk
