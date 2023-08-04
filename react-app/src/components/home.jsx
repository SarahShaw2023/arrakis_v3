import React, { useState, useEffect } from "react";
import { getAllBonds, getAllBondsMaturity, getAllTrades } from '../services/TradeServices';
import { useNavigate } from "react-router-dom";
import DatePicker from "react-datepicker";
import 'react-datepicker/dist/react-datepicker.css'

export const Home = ({userID, setUserID}) => {
    
    const [bonds,setBonds] = useState([]);
    const [bondsMaturity,setBondsMaturity] = useState([]);
    const [trades,setTrades] = useState([]);

    const [date, setDate] = useState(new Date());
    const navigate = useNavigate();
    useEffect(()=>{
        getBondsFromAPI();
        getTradesFromAPI()}, 
        []
    );
    const getBondsFromAPI = ()=>{
        getAllBonds()
            .then(res => {
                console.log(res.data);
                setBonds(res.data);
            })
            .catch(err => {
                setBonds([]);
                console.log(err);
        })
        getAllBondsMaturity(date)
            .then(res => {
                console.log(res.data);
                setBondsMaturity(res.data);
            })
            .catch(err => {
                setBondsMaturity([]);
                console.log(err);
        })
    }
    const getTradesFromAPI = ()=>{
        getAllTrades(userID)
            .then(res => {
                console.log(res.data);
                setTrades(res.data);
            })
            .catch(err => {
                setTrades([]);
                console.log(err);
        })
    }
    const statusCheck = (status) => {
        if (status === "active" || status === "open") {
            return <font color="green">{status}</font>;
        }
        return status;
    }
    const createBondRow = (data) => {     
        return <tr>
            <td>{data.couponPercent}</td>
            <td>{data.bondCurrency}</td>
            <td>{data.cusip}</td>
            <td>{data.faceValue}</td>
            <td>{data.isin}</td>
            <td>{data.issuerName}</td>
            <td>{data.bondMaturity}</td>
            <td>{statusCheck(data.status)}</td>
            <td>{data.type}</td>
        </tr>
    }
    const createTradeRow = (data) => {     
        return <tr>
            <td>{data.book_id}</td>
            <td>{data.bond_id}</td>
            <td>{data.counterparty_id}</td>
            <td>{data.quantity}</td>
            <td>{data.currency}</td>
            <td>{statusCheck(data.status)}</td>
            <td>{data.type}</td>
            <td>{data.unit_price}</td>
            <td>{statusCheck(data.trade_date)}</td>
            <td>{data.settlement_date}</td>
        </tr>
    }
    const onLogoutClick = () => {
        navigate("/");
    }
  return (
    <>
    <div class="align-right">
        <input type="button" onClick={onLogoutClick} value={"Logout"} class="right" />
      </div>
    <div>
        <table>
            <thead>
                <tr><th colSpan="9">All Bonds</th></tr>
            </thead>
            <tbody>
                <tr>
                    <th>Coupon Percent</th>
                    <th>Bond Currency</th>
                    <th>CUSIP</th>
                    <th>Face Value</th>
                    <th>ISIN</th>
                    <th>Issuer Name</th>
                    <th>Bond Maturity</th>
                    <th>Status</th>
                    <th>Type</th>
                </tr>
                {bonds.map(row => createBondRow(row))}
            </tbody>
            
        </table>
        
    </div>
    <div class="space"></div>
    <div>
        <table>
            <thead>
                <tr><th colSpan="10">All Trades</th></tr>
            </thead>
            <tbody>
                <tr>
                    <th>Book ID</th>
                    <th>Bond ID</th>
                    <th>Counterparty ID</th>
                    <th>Quantity</th>
                    <th>Currency</th>
                    <th>Status</th>
                    <th>Type</th>
                    <th>Unit Price</th>
                    <th>Trade Date</th>
                    <th>Settlement Date</th>
                </tr>
                {trades.map(row => createTradeRow(row))}
            </tbody>
            
        </table>
        
    </div>
    <div class="space"></div>
    <div>
      <DatePicker selected={date} onChange={(date) => {console.log(date.toISOString().split('T')[0]); setDate(date)}} />
    </div>
    <div>
    <table>
        <thead>
            <tr><th colSpan="9">All Bonds Within 5 Days</th></tr>
        </thead>
        <tbody>
            <tr>
                <th>Coupon Percent</th>
                <th>Bond Currency</th>
                <th>CUSIP</th>
                <th>Face Value</th>
                <th>ISIN</th>
                <th>Issuer Name</th>
                <th>Bond Maturity</th>
                <th>Status</th>
                <th>Type</th>
            </tr>
            {bondsMaturity.map(row => createBondRow(row))}
        </tbody>
        
    </table>

    </div> 
    <div class="space"></div>
    </>
  )
}

export default Home
