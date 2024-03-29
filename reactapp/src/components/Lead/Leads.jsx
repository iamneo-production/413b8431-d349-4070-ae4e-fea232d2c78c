import React, { useEffect, useState } from "react";
import { LuEdit } from "react-icons/lu";
import { RiDeleteBin2Fill } from "react-icons/ri";
import { CgSearch } from "react-icons/cg";
import { AiOutlineUserAdd } from "react-icons/ai";
import { useNavigate } from "react-router-dom";
import { ToastContainer, toast } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';
import Swal from "sweetalert2";
import "../../styles/Customers.css";
import "../Customer/Delete.css"
import axios from "axios";
import Footer from "../Footer/Footer";

const Leads = ({ leads }) => {

  const [allleads, setAllleads] = useState([]);

  const [searchQuery, setSearchQuery] = useState("");

  const [deleteMessage, setDeleteMessage] = useState("");

  const navigate = useNavigate();

  const handleSearchInputChange = (event) => {
    setSearchQuery(event.target.value);
  };



  useEffect(()=>{
    loadCustomer();
  } , [])

  const loadCustomer = async () => {
    try {
      const response = await axios.get("https://8080-edfdbecdceefbfbcdcaeeaebabeaeaadbdbabf.project.examly.io/lead");
      const data = response.data; 
  
      setAllleads(data);
      console.log(allleads);
    } catch (error) {
      console.error(error);
      Swal.fire(
        'Something went wrong!',
        'warning'
      )
    }
  };
  


  const moveToAddNewLeadPage = () => {
    navigate("/add-new-lead");
  };

  const handleEdit = (id) =>{
    navigate(`/editlead/${id}`)
  }

  const handleDelete = async (id) => { 
    try {
      Swal.fire({
        title: 'Are you sure?',
        text: "You won't be able to revert this!",
        icon: 'warning',
        showCancelButton: true,
        confirmButtonColor: '#3085d6',
        cancelButtonColor: '#d33',
        confirmButtonText: 'Yes, delete it!'
      }).then(async (result) => {
        if (result.isConfirmed) {
          await axios.delete(`https://8080-edfdbecdceefbfbcdcaeeaebabeaeaadbdbabf.project.examly.io/lead/${id}`);
          setAllleads((prevLeads) =>
            prevLeads.filter((lead) => lead.id !== id)
          );
          Swal.fire(
            'Deleted!',
            'Your file has been deleted.',
            'success'
          );
        }
      });
    } catch (error) {
      console.log(error);
      Swal.fire(
        'Something went wrong!',
        'warning'
      )
    }
  };
  
  return (
    <div className="customers-page">
      <div className="header-section">
        <div className="search-bar">
          <CgSearch fontSize="1.6rem" />
          <input
            type="text"
            placeholder="Search..."
            value={searchQuery}
            onChange={handleSearchInputChange}
          />
        </div>
        <button className="add-customer-btn" onClick={moveToAddNewLeadPage}>
          <AiOutlineUserAdd fontSize="1.6rem" />
          <p>Add Lead</p>
        </button>
      </div>
      <div className="customer-table">
        <table>
          <thead>
            <tr>
              <th>S No.</th>
              <th>Lead Id</th>
              <th>Name</th>
              <th>Email</th>
              <th>Phone</th>
              <th>Source</th>
              <th>Status</th>
              <th>Notes</th>
              <th>Actions</th>
            </tr>
          </thead>
          <tbody>
            {allleads
              .filter((lead) => {
                return (
                  lead.name.toLowerCase().includes(searchQuery) ||
                  lead.email.toLowerCase().includes(searchQuery)
                  // || lead.id.toString().includes(searchQuery)
                );
              })
            .map((eachLead, index) => (
                <tr key={index}>
                  <td>{index + 1}</td>
                  <td>{eachLead.id}</td>
                  <td>{eachLead.name}</td>
                  <td>{eachLead.email}</td>
                  <td>{eachLead.phone}</td>
                  <td>{eachLead.source}</td>
                  <td>{eachLead.status}</td>
                  <td>{eachLead.notes}</td>
                  <td className="action-btns">
                    <div className="action-btn">
                      <LuEdit className="action-btn-component1" fontSize="1.6rem" onClick={()=>handleEdit(eachLead.id)}/>
                      <RiDeleteBin2Fill className="action-btn-component1" fontSize="1.6rem" onClick={()=>handleDelete(eachLead.id)}/>
                    </div>
                  </td>
                </tr>
            ))}
          </tbody>
        </table>
      </div>
      {deleteMessage && <p className="delete-message">{deleteMessage}</p>}
      {/* <Footer/> */}
    </div>
  );
};

export default Leads;
