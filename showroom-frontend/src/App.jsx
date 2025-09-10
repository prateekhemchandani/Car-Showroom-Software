import { useEffect, useState } from "react";
import { getShowrooms, getEmployeesByShowroom, getCarsByShowroom } from "./services/api";
import "./App.css"; // We'll add styles here

function App() {
  const [showrooms, setShowrooms] = useState([]);
  const [selectedShowroom, setSelectedShowroom] = useState(null);
  const [employees, setEmployees] = useState([]);
  const [cars, setCars] = useState([]);

  useEffect(() => {
    getShowrooms().then(res => setShowrooms(res.data));
  }, []);

  const handleShowroomSelect = (showroom) => {
    setSelectedShowroom(showroom);
    getEmployeesByShowroom(showroom.id).then(res => setEmployees(res.data));
    getCarsByShowroom(showroom.id).then(res => setCars(res.data));
  };

  return (
    <div className="container">
      <header>
        <h1>🚗 Showroom Management Dashboard</h1>
      </header>

      <section>
        <h2>Showrooms</h2>
        <div className="showroom-grid">
          {showrooms.map(s => (
            <div
              key={s.id}
              className={`showroom-card ${selectedShowroom?.id === s.id ? "active" : ""}`}
              onClick={() => handleShowroomSelect(s)}
            >
              <h3>{s.name}</h3>
              <p>{s.address}</p>
            </div>
          ))}
        </div>
      </section>

      {selectedShowroom && (
        <section>
          <h2>Selected Showroom: {selectedShowroom.name}</h2>

          <div className="cards-container">
            <div className="card">
              <h3>Employees</h3>
              {employees.length === 0 ? <p>No employees yet</p> :
                <ul>
                  {employees.map(e => (
                    <li key={e.id}>{e.name} - {e.department}</li>
                  ))}
                </ul>
              }
            </div>

            <div className="card">
              <h3>Cars</h3>
              {cars.length === 0 ? <p>No cars yet</p> :
                <ul>
                  {cars.map(c => (
                    <li key={c.id}>{c.name} - {c.type} - ${c.price}</li>
                  ))}
                </ul>
              }
            </div>
          </div>
        </section>
      )}
    </div>
  );
}

export default App;
