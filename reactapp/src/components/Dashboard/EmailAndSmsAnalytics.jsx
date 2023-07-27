import React from 'react'
import { useState,useEffect } from 'react';
import axios from 'axios';
import './EmailAndSmsAnalytics.css';

const EmailAndSmsAnalytics = () => {

    const [emailCount, setEmailCount] = useState(0);
    const [smsCount, setSmsCount] = useState(0);
  
    useEffect(() => {
          fetchEmailCount();
          fetchSMSCount();
      }, []);
  
      const fetchEmailCount = async () => {
        try {
            const response = await axios.get('https://8080-afeeccafebfbbcdcaeeaebabeaeaadbdbabf.project.examly.io/analytics/emailCount');
            setEmailCount(response.data);
        } catch (error) {
            console.error(error);
        }
      }
  
      const fetchSMSCount = async () => {
        try {
            const response = await axios.get('https://8080-afeeccafebfbbcdcaeeaebabeaeaadbdbabf.project.examly.io/analytics/smsCount');
            setSmsCount(response.data);
        } catch (error) {
            console.error(error);
        }
      }
  return (
        <div className='email-sms'>
            <div className="analytics-box" >
            <p className='emailsms-container'>Emails Today <span className="blueBox">{emailCount}</span></p>
            </div>
            <div className="analytics-box" >
            <p className='emailsms-container'>SMS Today<span className="blueBox">{smsCount}</span></p>
            </div>
        </div>
  )
}

export default EmailAndSmsAnalytics