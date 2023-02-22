package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import java.math.BigInteger
import java.math.BigDecimal

class MainActivity : AppCompatActivity() {
    private var check=true
    private var checkInfinity=true
    private var textCalc:TextView?=null
    private var textResult:TextView?=null
    private var btnOne:Button?=null
    private var btnTwo:Button?=null
    private var btnThree:Button?=null
    private var btnFour:Button?=null
    private var btnFive:Button?=null
    private var btnSix:Button?=null
    private var btnSeven:Button?=null
    private var btn8:Button?=null
    private var btn9:Button?=null
    private var btnCancel:Button?=null
    private var btnMod:Button?=null
    private var btnSum:Button?=null
    private var btnSub:Button?=null
    private var btnDiv:Button?=null
    private var btnMul:Button?=null
    private var btnEqual:Button?=null
    private var btnZero:Button?=null
    private var btnDod:Button?=null
    private var btnPlusMin:Button?=null
    private var btnDivOne:Button?=null
    private var btnPower:Button?=null
    private var btnSquare:Button?=null
    private var btnClear:Button?=null
    private var btnClearResult:Button?=null
    private val calcName="calcName"
    private val resultName="resultName"
    private val checkName="checkName"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initialization()
    }

    override fun onResume() {
        super.onResume()
        setOnClickToNumber()
        onClickOperationMath()
        btnEqual!!.setOnClickListener {
            if(textResult?.text.toString().isNotEmpty()&&textCalc?.text.toString().isNotEmpty()) {
                implementEqual()
            }
        }
        btnCancel!!.setOnClickListener {
            if(textCalc?.text.toString()!=""){
                check=true
                textCalc!!.text=""
            }else{
                val varTextResult=textResult!!.text.toString()
                val textNewAfterDelete= getTextCalcOld(varTextResult)
                textResult?.text=textNewAfterDelete
            }
        }
    }

    // code equal
    private fun implementEqual() {
        check = true
        val getTextCalc = textCalc!!.text.toString()
        if(getTextCalc[getTextCalc.length-1]!='='){
            val getTextCalc = textCalc!!.text.toString()
            val getTextResult = textResult!!.text.toString()
            val textFinal = "$getTextCalc$getTextResult="
            val lastCharEqualOperation = getTextCalc[getTextCalc.length - 1]
            val textInCalcUseInCalc = getTextCalcOld(getTextCalc)
            val boo = checkDodOrNo(textResult!!)
            val booleanCheckDod = checkDodOrNo(textCalc!!)
            executeBasOperation(lastCharEqualOperation, boo, booleanCheckDod, textInCalcUseInCalc, getTextResult,' ')
            textCalc?.text=textFinal
        }
    }
    //get number-last element
    private fun getTextCalcOld(getTextCalc: String): String {
        var numberCo1 = ""
        for (i in 0..getTextCalc.length - 2) {
            numberCo1 += getTextCalc[i]
        }
        return numberCo1
    }
    //initialization variable
    private fun initialization() {
        textCalc = findViewById(R.id.texcalc)
        textResult = findViewById(R.id.textrsult)
        btnOne = findViewById(R.id.btn1)
        btnTwo = findViewById(R.id.btn2)
        btnThree = findViewById(R.id.btn3)
        btnFour = findViewById(R.id.btn4)
        btnFive = findViewById(R.id.btn5)
        btnSix = findViewById(R.id.btn6)
        btnSeven = findViewById(R.id.btn7)
        btn8 = findViewById(R.id.btn8)
        btn9 = findViewById(R.id.btn9)
        btnCancel = findViewById(R.id.btncancel)
        btnMod = findViewById(R.id.btnmod)
        btnSum = findViewById(R.id.btnsum)
        btnSub = findViewById(R.id.btnsub)
        btnDiv = findViewById(R.id.btndiv)
        btnMul = findViewById(R.id.btnmul)
        btnEqual = findViewById(R.id.btnequal)
        btnZero = findViewById(R.id.btn0)
        btnDod = findViewById(R.id.btndod)
        btnPlusMin=findViewById(R.id.btnplusmun)
        btnDivOne=findViewById(R.id.onedivm)
        btnPower=findViewById(R.id.power)
        btnSquare=findViewById(R.id.squre)
        btnClear=findViewById(R.id.clearTextId)
        btnClearResult=findViewById(R.id.clearTextResultId)
    }
    //check number double or long
    private fun checkDodOrNo(text:TextView): Boolean {
        var bool = true
        val sTextNumber = text.text.toString()
        if ('.' in sTextNumber){
            bool=false
        }
        return bool
    }
    // add all number to screen
    private fun setInValue(num:Char){
        if (check){
            textResult?.text=num.toString()
            check=false
            val calcTextNew=getTextCalcOld(textCalc?.text.toString())
            if(calcTextNew=="Infinity"){
                textCalc?.text=""
                checkInfinity=true
            }
        }else{
            var textOld=textResult?.text.toString()
            textOld+=num.toString()
            textResult?.text=textOld
        }
    }
    private fun setOnClickToNumber() {
        btnPlusMin!!.setOnClickListener {
            try {
                val checkTrueOrFalse=checkDodOrNo(textResult!!)
                val mOne= BigInteger((-1).toString())
                if(checkTrueOrFalse){
                    val number= BigInteger(textResult?.text.toString())
                    textResult?.text="${(number.multiply(mOne))}"
                }else{
                    var number:BigDecimal= BigDecimal(textResult?.text.toString())
                    textResult?.text="${(number.multiply((mOne).toBigDecimal()))}"
                }}catch (ex:Exception){

            }
        }
        btnZero!!.setOnClickListener {
            setInValue('0')
        }
        btnOne!!.setOnClickListener {
            setInValue('1')
        }
        btnTwo!!.setOnClickListener {
            setInValue('2')
        }
        btnThree!!.setOnClickListener {
            setInValue('3')
        }
        btnFour!!.setOnClickListener {
            setInValue('4')
        }
        btnFive!!.setOnClickListener {
            setInValue('5')
        }
        btnSix!!.setOnClickListener {
            setInValue('6')
        }
        btnSeven!!.setOnClickListener {
            setInValue('7')
        }
        btn8!!.setOnClickListener {
            setInValue('8')
        }
        btn9!!.setOnClickListener {
            setInValue('9')
        }
        btnDod!!.setOnClickListener {
            val checkTrueOrFalse = checkDodOrNo(textResult!!)
            if(checkTrueOrFalse) {
                setInValue('.')
            }
        }
        btnClear?.setOnClickListener {
            textCalc?.text=""
            textResult?.text=""
        }
        btnClearResult?.setOnClickListener {
            textResult?.text=""
        }
    }
    // end
    //when click / ex

    private fun division(
        checkDodInTextResult: Boolean,
        checkDodInTextCalc: Boolean,
        numberUseInOperationExistInCalcField: String,
        textExistInResultField: String,
        charOperationSelectedByUser: Char,
    ) {
        try {
            val numberResultDoublePlus: Double = numberUseInOperationExistInCalcField.toDouble() / textExistInResultField.toDouble()
            if (numberResultDoublePlus % 1 == 0.0) {
                textCalc!!.text =
                    "${numberResultDoublePlus.toLong()}$charOperationSelectedByUser"
                textResult!!.text = numberResultDoublePlus.toLong().toString()
            } else {
                textCalc!!.text = "$numberResultDoublePlus" + charOperationSelectedByUser
                textResult!!.text = "$numberResultDoublePlus"
            }
        }catch (ex:Exception){
            textResult!!.text = "0.0"
        }
        if(textResult?.text.toString()=="Infinity"||textResult?.text.toString()=="NaN"){
            checkInfinity=false
        }
    }
    //when click * ex
    private fun mul(checkDodInTextResult: Boolean,
                    checkDodInTextCalc: Boolean,
                    numberUseInOperationExistInCalcField: String,
                    textExistInResultField: String,
                    charOperationSelectedByUser: Char,
    ) {
        var numberResultPlus = BigInteger("0")
        var numberResultDoublePlus = BigDecimal("0.0")
        if (checkDodInTextResult && checkDodInTextCalc) {
            numberResultPlus = BigInteger(numberUseInOperationExistInCalcField).multiply(BigInteger(textExistInResultField))
            textCalc?.text = "$numberResultPlus" + charOperationSelectedByUser
            textResult?.text = "$numberResultPlus"
        } else {
            numberResultDoublePlus =BigDecimal(numberUseInOperationExistInCalcField).multiply(BigDecimal(textExistInResultField))
            textCalc!!.text = "$numberResultDoublePlus$charOperationSelectedByUser"
            textResult!!.text= "$numberResultDoublePlus"
        }
    }
    //when click - ex
    private fun sub(
        checkDodInTextResult: Boolean,
        checkDodInTextCalc: Boolean,
        numberUseInOperationExistInCalcField: String,
        textExistInResultField: String,
        charOperationSelectedByUser: Char,
    ) {
        var numberResultPlus = BigInteger("0")
        var numberResultDoublePlus = BigDecimal("0.0")
        if (checkDodInTextResult && checkDodInTextCalc) {
            numberResultPlus = BigInteger(numberUseInOperationExistInCalcField).subtract(BigInteger(textExistInResultField))
            textCalc?.text = "$numberResultPlus$charOperationSelectedByUser"
            textResult?.text = "$numberResultPlus"
        } else {
            numberResultDoublePlus =BigDecimal(numberUseInOperationExistInCalcField).subtract(BigDecimal(textExistInResultField))
            textCalc!!.text = "$numberResultDoublePlus$charOperationSelectedByUser"
            textResult!!.text= "$numberResultDoublePlus"
        }
    }
    //when click + ex
    private fun plus(
        checkDodInTextResult: Boolean,
        checkDodInTextCalc: Boolean,
        numberUseInOperationExistInCalcField: String,
        textExistInResultField: String,
        charOperationSelectedByUser: Char
    ){
        var numberResultPlus =BigInteger("0")
        var numberResultDoublePlus = BigDecimal("0.0")
        if (checkDodInTextResult && checkDodInTextCalc) {
            numberResultPlus = BigInteger(numberUseInOperationExistInCalcField).add(BigInteger(textExistInResultField));
            textCalc?.text= "$numberResultPlus$charOperationSelectedByUser"
            textResult?.text= "$numberResultPlus"
        } else {
            numberResultDoublePlus = BigDecimal(numberUseInOperationExistInCalcField).add(BigDecimal(textExistInResultField))
            textCalc!!.text = "$numberResultDoublePlus$charOperationSelectedByUser"
            textResult!!.text= "$numberResultDoublePlus"
        }
    }
    //when click % ex
    private fun mod(
        checkDodInTextResult: Boolean,
        checkDodInTextCalc: Boolean,
        numberUseInOperationExistInCalcField: String,
        textExistInResultField: String,
        charOperationSelectedByUser: Char,
    ) {
        var numberResultPlus = BigInteger("0")
        if (checkDodInTextResult && checkDodInTextCalc) {
            numberResultPlus = BigInteger(numberUseInOperationExistInCalcField).mod(BigInteger(textExistInResultField))
            textCalc?.text = "$numberResultPlus$charOperationSelectedByUser"
            textResult?.text = "$numberResultPlus"
        } else {
            try {
                val numberCalc = numberUseInOperationExistInCalcField.toDouble()
                var numberResult = textExistInResultField.toDouble()
                val resultCalc = numberCalc % numberCalc
                textResult?.text = resultCalc.toString()
            }catch (ex:Exception){
                textResult?.text ="0.0"
            }
        }
    }
    //check select user and ex method above
    private fun executeBasOperation(
        lastCharacterInTextCalc: Char,
        checkDodInTextResult: Boolean,
        checkDodInTextCalc: Boolean,
        numberUseInOperationExistInCalcField: String,
        textExistInResultField: String,
        charOperationSelectedByUser: Char
    ) {
        when (lastCharacterInTextCalc) {
            '+' -> {
                plus(checkDodInTextResult, checkDodInTextCalc, numberUseInOperationExistInCalcField, textExistInResultField, charOperationSelectedByUser)
            }
            '-' -> {
                sub(checkDodInTextResult, checkDodInTextCalc, numberUseInOperationExistInCalcField, textExistInResultField, charOperationSelectedByUser)
            }
            '×' -> {
                mul(checkDodInTextResult, checkDodInTextCalc, numberUseInOperationExistInCalcField, textExistInResultField, charOperationSelectedByUser)
            }
            '÷' -> {
                division(checkDodInTextResult, checkDodInTextCalc, numberUseInOperationExistInCalcField, textExistInResultField, charOperationSelectedByUser)
            }
            '%' -> {
                mod(checkDodInTextResult, checkDodInTextCalc, numberUseInOperationExistInCalcField, textExistInResultField, charOperationSelectedByUser)
            }
        }
    }

    //code add operation
    private fun calcResult(charOperationSelectedByUser:Char){
        if(textResult?.text.toString()=="."){
            textResult?.text="0"
        }
        if(!checkInfinity){
            textResult?.text=""
            checkInfinity=true
            val calcTextNew=getTextCalcOld(textCalc?.text.toString())
            if(calcTextNew=="Infinity"||calcTextNew=="NaN"){
                textCalc?.text=""
            }
        }else if(!(textResult?.text.toString().isEmpty())){
            check=true
            val textInCalc =textCalc?.text.toString()
            if(textCalc?.text.toString().isEmpty()||textInCalc[textInCalc.length-1]=='='){
                val textInResult =textResult?.text.toString()
                textCalc?.text=("$textInResult$charOperationSelectedByUser")
            }else{
                val checkDodInTextResult=checkDodOrNo(textResult!!)
                val checkDodInTextCalc=checkDodOrNo(textCalc!!)
                val textExistInResultField =textResult?.text.toString()
                val lastCharacterInTextCalc:Char=textInCalc[textInCalc.length-1]
                val numberUseInOperation= getTextCalcOld(textInCalc)
                executeBasOperation(lastCharacterInTextCalc, checkDodInTextResult, checkDodInTextCalc, numberUseInOperation, textExistInResultField, charOperationSelectedByUser)
            }
        }
    }
    //operation math
    private fun onClickOperationMath() {
        btnSum?.setOnClickListener {
            calcResult('+')
        }
        btnSub?.setOnClickListener {
            calcResult('-')
        }
        btnMod?.setOnClickListener {
            calcResult('%')
        }
        btnDiv?.setOnClickListener {
            calcResult('÷')
        }
        btnMul?.setOnClickListener {
            calcResult('×')
        }
        btnSquare?.setOnClickListener {
            val charHieghtOperation=btnSquare?.text.toString()
            operationHeight(charHieghtOperation[0])
        }
        btnPower?.setOnClickListener {
            val charHieghtOperation=btnPower?.text.toString()
            operationHeight(charHieghtOperation[0])
        }
        btnDivOne?.setOnClickListener {
            operationHeight('/')
        }
    }
    //  operation height /1/m /pow / sqr
    private fun operationHeight(charSelectedByUser:Char){
        if(textResult?.text.toString()=="."){
            textResult?.text="0"
        }
        if(!checkInfinity){
            textResult?.text=""
            checkInfinity=true
            val calcTextNew=getTextCalcOld(textCalc?.text.toString())
            if(calcTextNew=="Infinity"||calcTextNew=="NaN"){
                textCalc?.text=""
            }
        } else if(textResult?.text.toString().isNotEmpty()){
            check=true
            val charPower=btnPower!!.text.toString()
            val charSquare=btnSquare!!.text.toString()
            val textResult= textResult?.text.toString()
            var textCalc=textCalc?.text.toString()
            var resultAfterImplementationOperation:BigDecimal= BigDecimal("0.0")
            if(charSelectedByUser=='/'){
                try {
                    val resultDivOneAfterImplementationOperation: Double = 1.0 / textResult.toDouble()
                    if (this.textCalc?.text.toString()
                            .isEmpty() || textCalc[textCalc.length - 1] == '='
                    ) {
                        this.textResult?.text = resultDivOneAfterImplementationOperation.toString()
                        textCalc = ""
                    } else {
                        val numberInCalcField = getTextCalcOld(textCalc)
                        executeBasOperation(
                            textCalc[textCalc.length - 1],
                            false,
                            false,
                            numberInCalcField,
                            resultDivOneAfterImplementationOperation.toString(),
                            '='
                        )
                    }
                    this.textCalc?.text = "${textCalc}1/${textResult.toString()}="
                }catch (ex:Exception){
                }
                if(this.textResult?.text.toString()=="Infinity"){
                    checkInfinity=false
                }
            }else if(charSelectedByUser==charPower[0]){
                resultAfterImplementationOperation = BigDecimal(textResult).pow(2)
                if(this.textCalc?.text.toString().isEmpty()||textCalc[textCalc.length-1]=='=') {
                    this.textResult?.text= "$resultAfterImplementationOperation"
                    textCalc=""
                }else{
                    val numberInCalcField = getTextCalcOld(textCalc)
                    executeBasOperation(textCalc[textCalc.length-1], false, false,  numberInCalcField, resultAfterImplementationOperation.toString(), '=')
                }
                this.textCalc?.text= "${textCalc}sqr(${textResult.toString()})="
            }else if(charSelectedByUser==charSquare[0]){
                try {
                    val resultSqrtAfterImplementationOperation: Double = Math.sqrt(textResult.toDouble())
                    if(this.textCalc?.text.toString().isEmpty()||textCalc[textCalc.length-1]=='=') {
                        this.textResult?.text=resultSqrtAfterImplementationOperation.toString()
                        textCalc=""
                    }else{
                        val numberInCalcField = getTextCalcOld(textCalc)
                        executeBasOperation(textCalc[textCalc.length-1], false, false,  numberInCalcField, resultSqrtAfterImplementationOperation.toString(), '=')
                    }
                    this.textCalc?.text= "$textCalc${btnSquare?.text.toString()}(${textResult.toString()})="
                }catch (ex:Exception){
                }
            }
        }
    }
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(resultName,textResult?.text.toString());
        outState.putString(calcName,textCalc?.text.toString())
        outState.putBoolean(checkName,check)
    }
    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        textResult?.text=savedInstanceState.getString(resultName)
        textCalc?.text=savedInstanceState.getString(calcName)
        check=savedInstanceState.getBoolean(checkName)
    }
}